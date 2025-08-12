package br.com.leroymarcel.store.domain.dto;

import br.com.leroymarcel.store.domain.entity.ClassificacaoEnum;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.domain.entity.TipoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProdutoOutputDTO {
    private String id;
    private String nome;
    private TipoEnum tipo;
    private ClassificacaoEnum classificacao;
    private Double tamanho;
    private BigDecimal preco;

    public static ProdutoOutputDTO entidadeParaDto(Produto produto){
        return ProdutoOutputDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .tipo(produto.getTipo())
                .classificacao(produto.getClassificacao())
                .tamanho(produto.getTamanho())
                .preco(produto.getPreco())
                .build();
    }

    public static Page<ProdutoOutputDTO> entidadeParaDto(Page<Produto> produtos){
        return produtos.map(ProdutoOutputDTO::entidadeParaDto);
    }
}
