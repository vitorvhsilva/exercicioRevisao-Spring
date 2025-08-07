package br.com.leroymarcel.store.domain.dto;

import br.com.leroymarcel.store.domain.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AtualizarProdutoInputDTO {
    @NotBlank @Size(min = 3)
    private String nome;
    @NotNull
    private Integer quantidade;
    @NotNull
    private Double preco;

    public static Produto dtoParaEntidade(AtualizarProdutoInputDTO dto){
        return Produto.builder()
                .id(null)
                .nome(dto.getNome())
                .marca(null)
                .quantidade(dto.getQuantidade())
                .preco(dto.getPreco())
                .build();
    }
}
