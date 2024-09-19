package com.carteiraInvestimentos.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAtivo {

    FII("Fundo imobiliário"), ACAO("Ação"), ETF("ETF");

    private final String descricao;
}
