package com.carteiraInvestimentos.demo.domain;

import com.carteiraInvestimentos.demo.enums.TipoAtivo;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ativo", schema = "carteira")
public class Ativo {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ticker")
    private String ticker;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoAtivo tipo;

    @Column(name = "valor_patrimonial")
    private BigDecimal valorPatrimonial;
}
