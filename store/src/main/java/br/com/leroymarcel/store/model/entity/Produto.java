package br.com.leroymarcel.store.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TDS_TB_FERRAMENTAS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_produto", nullable = false)
    private String id;
    @Column(name = "nome_produto", nullable = false)
    private String nome;
    @Column(name = "marca_produto", nullable = false)
    private String marca;
    @Column(name = "quantidade_produto", nullable = false)
    private Integer quantidade;
    @Column(name = "preco_produto", nullable = false)
    private Double preco;
}
