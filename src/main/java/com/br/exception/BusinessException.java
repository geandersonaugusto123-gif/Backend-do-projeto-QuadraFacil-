package com.br.exception;

// Exceção utilizada para representar regras de negócio do sistema
// Ex: tentativa de criar uma reserva em horário já ocupado
public class BusinessException extends RuntimeException {

    // Recebe uma mensagem personalizada, facilitando o entendimento do erro
    public BusinessException(String mensagem) {
        super(mensagem);
    }
}