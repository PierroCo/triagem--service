package com.consultoria.triagem.application.domain.exceptions;

public class TriagemNotFoundException extends RuntimeException {

    public TriagemNotFoundException(String message) {
        super(message);
    }

    public TriagemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}