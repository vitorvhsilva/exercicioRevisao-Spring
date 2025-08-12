package br.com.leroymarcel.store.domain.dto;

import br.com.leroymarcel.store.domain.entity.ClassificacaoEnum;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.domain.entity.TipoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AtualizarProdutoInputDTO {
    @NotBlank @Size(min = 3)
    private String nome;
    @NotNull
    private TipoEnum tipo;
    @NotNull
    private ClassificacaoEnum classificacao;
    @NotNull
    private Double tamanho;
    @NotNull
    private BigDecimal preco;

    public static Produto dtoParaEntidade(AtualizarProdutoInputDTO dto){
        return Produto.builder()
                .id(null)
                .nome(dto.getNome())
                .tipo(dto.getTipo())
                .classificacao(dto.getClassificacao())
                .tamanho(dto.getTamanho())
                .preco(dto.getPreco())
                .build();
    }
}
