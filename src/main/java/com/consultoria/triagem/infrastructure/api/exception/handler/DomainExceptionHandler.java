package com.consultoria.triagem.infrastructure.api.exception.handler;

import com.consultoria.triagem.application.useCases.exceptions.DomainException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class DomainExceptionHandler {
    private final DomainError domainError = new DomainError();

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<DomainError> trataErroDominio(DomainException e, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        domainError.setTimestamp(Instant.now());
        domainError.setStatus(status.value());
        domainError.setError("Parâmetros inconsistentes");
        domainError.setMessage(e.getMessage());
        domainError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(domainError);
    }
}
