package br.com.leroymarcel.store.controller;

import br.com.leroymarcel.store.domain.dto.AtualizarProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.CadastroProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.ProdutoModelAssembler;
import br.com.leroymarcel.store.domain.dto.ProdutoOutputDTO;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.service.ProdutoLoggerService;
import br.com.leroymarcel.store.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService produtoService;
    private ProdutoModelAssembler assembler;

    @PostMapping
    public ResponseEntity<EntityModel<ProdutoOutputDTO>> criarProduto(@RequestBody @Valid CadastroProdutoInputDTO inputDTO) {
        Produto produto = CadastroProdutoInputDTO.dtoParaEntidade(inputDTO);
        Produto produtoCriado = produtoService.criarProduto(produto);
        EntityModel<ProdutoOutputDTO> model = assembler.toModel(produtoCriado);
        ProdutoLoggerService.sucesso("Produto criado com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    @GetMapping
    public Page<ProdutoOutputDTO> obterTodosOsProdutos(
        @RequestParam(defaultValue = "0", required = false) @Min(0) Integer pagina,
        @RequestParam(defaultValue = "5", required = false) Integer tamanho
    ){
        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<ProdutoOutputDTO> outputsDTO = ProdutoOutputDTO.entidadeParaDto(produtoService.obterTodosOsProdutos(pageable));
        ProdutoLoggerService.sucesso("Produtos retornados com sucesso!");
        return outputsDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProdutoOutputDTO>> obterProduto(@PathVariable String id) {
        Produto produto = produtoService.obterProduto(id);
        EntityModel<ProdutoOutputDTO> model = assembler.toModel(produto);
        ProdutoLoggerService.sucesso("Produtos obtido com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<ProdutoOutputDTO>> atualizarProduto(
        @PathVariable String id,
        @RequestBody AtualizarProdutoInputDTO inputDTO
    ) {
        Produto produto = AtualizarProdutoInputDTO.dtoParaEntidade(inputDTO);
        produto = produtoService.atualizarProduto(produto, id);
        EntityModel<ProdutoOutputDTO> model = assembler.toModel(produto);
        ProdutoLoggerService.sucesso("Produto atualizado com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String id) {
        produtoService.deletarProduto(id);
        ProdutoLoggerService.sucesso("Produtos excluido com sucesso!");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
