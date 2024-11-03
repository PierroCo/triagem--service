package com.consultoria.triagem.application.domain.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        this(message, null);
    }

    public DomainException(final String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
