package com.consultoria.triagem.application.domain.exceptions;

public class ScreeningNotFoundException extends RuntimeException {

    public ScreeningNotFoundException(String message) {
        super(message);
    }

    public ScreeningNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}