package br.com.leroymarcel.store.domain.dto;

import br.com.leroymarcel.store.domain.entity.Produto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoOutputDTO {
    private String id;
    private String nome;
    private String marca;
    private Integer quantidade;
    private Double preco;

    public static ProdutoOutputDTO entidadeParaDto(Produto produto){
        return ProdutoOutputDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .marca(produto.getMarca())
                .quantidade(produto.getQuantidade())
                .preco(produto.getPreco())
                .build();
    }
}
