package com.carteiraInvestimentos.demo.exceptions;

public class RegistroIncompletoException extends RuntimeException {

    public RegistroIncompletoException(String mensagem) {
        super(mensagem);
    }
}