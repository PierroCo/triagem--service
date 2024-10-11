package com.consultoria.triagem__service.application.domain.exceptions;

public class NotFoundException extends DomainException {
    public NotFoundException(final String message) {
        super(message);
    }
}
