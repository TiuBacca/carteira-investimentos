package com.carteiraInvestimentos.demo.service;

import java.util.List;

public interface CRUDService {

    void salvar(Object object) throws Exception;
    void remover(Object object);
    List listar(Object object);

}

