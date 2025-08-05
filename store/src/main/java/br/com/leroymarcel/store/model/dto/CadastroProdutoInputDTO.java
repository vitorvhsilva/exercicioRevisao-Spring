package br.com.leroymarcel.store.model.dto;

import br.com.leroymarcel.store.model.entity.Produto;
import lombok.Data;

@Data
public class CadastroProdutoInputDTO {
    private String nome;
    private String marca;
    private Integer quantidade;
    private Double preco;

    public static Produto dtoParaEntidade(CadastroProdutoInputDTO dto){
        return Produto.builder()
                .id(null)
                .nome(dto.getNome())
                .marca(dto.getMarca())
                .quantidade(dto.getQuantidade())
                .preco(dto.getPreco())
                .build();
    }
}
