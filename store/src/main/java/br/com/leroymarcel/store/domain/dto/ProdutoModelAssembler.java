package br.com.leroymarcel.store.domain.dto;

import br.com.leroymarcel.store.controller.ProdutoController;
import br.com.leroymarcel.store.domain.entity.Produto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProdutoModelAssembler implements RepresentationModelAssembler<Produto, EntityModel<ProdutoOutputDTO>> {

    @Override
    public EntityModel<ProdutoOutputDTO> toModel(Produto produto) {
        ProdutoOutputDTO dto = ProdutoOutputDTO.entidadeParaDto(produto);

        return EntityModel.of(dto,
                linkTo(methodOn(ProdutoController.class).obterProduto(produto.getId())).withSelfRel().withType("GET"),
                linkTo(methodOn(ProdutoController.class).excluirProduto(produto.getId())).withRel("excluir").withType("DELETE"),
                linkTo(methodOn(ProdutoController.class).atualizarProduto(produto.getId(), null)).withRel("atualizar").withType("PATCH")
        );
    }
}