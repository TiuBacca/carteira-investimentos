package com.carteiraInvestimentos.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cotacao", schema = "carteira")
public class Cotacao {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "preco")
    private BigDecimal preco;
}
