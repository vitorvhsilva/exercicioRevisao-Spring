package br.com.leroymarcel.store.model.dto;

import lombok.Data;

@Data
public class AtualizarProdutoInputDTO {
    private String id;
    private String nome;
    private String marca;
    private Integer quantidade;
    private Double preco;
}
