package com.consultoria.triagem.application.domain.exceptions;

public class NotFoundException extends DomainException {
    public NotFoundException(final String message) {
        super(message);
    }
}
