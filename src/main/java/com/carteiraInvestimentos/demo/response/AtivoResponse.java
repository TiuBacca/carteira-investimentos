package com.carteiraInvestimentos.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtivoResponse {

    private Long id;
    private String ticker;
    private String tipo;
}
