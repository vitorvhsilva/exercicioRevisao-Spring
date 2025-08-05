package br.com.leroymarcel.store.model.dto;

import br.com.leroymarcel.store.model.entity.Produto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastroProdutoOutputDTO {
    private String id;
    private String nome;
    private String marca;
    private Integer quantidade;
    private Double preco;

    public static CadastroProdutoOutputDTO entidadeParaDto(Produto produto){
        return CadastroProdutoOutputDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .marca(produto.getMarca())
                .quantidade(produto.getQuantidade())
                .preco(produto.getPreco())
                .build();
    }
}
