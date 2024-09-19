package com.carteiraInvestimentos.demo.filtro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtivoFiltro {

    private Long id;
    private String ticker;
    private ArrayList<String> tipos;
}
