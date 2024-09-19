package com.carteiraInvestimentos.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtivoRequest {

    private Long id;
    private String ticker;
    private String tipo;
    private Boolean ativo;

}
