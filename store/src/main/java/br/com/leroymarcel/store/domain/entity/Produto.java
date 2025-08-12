package br.com.leroymarcel.store.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @Column(name = "tipo_produto", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;
    @Column(name = "classificacao_produto", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassificacaoEnum classificacao;
    @Column(name = "tamanho_produto", nullable = false)
    private Double tamanho;
    @Column(name = "preco_produto", nullable = false)
    private BigDecimal preco;
}

