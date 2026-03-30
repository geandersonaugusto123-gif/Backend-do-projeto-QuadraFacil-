package com.br.exception;

// Exceção utilizada quando um registro não é encontrado no sistema
// Normalmente aplicada em buscas por ID que não retornam resultado
public class ResourceNotFoundException extends RuntimeException {

    // Recebe a mensagem personalizada para deixar claro qual recurso não foi encontrado
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}