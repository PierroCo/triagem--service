package com.consultoria.triagem.infrastructure.api.exception.handler;

import com.consultoria.triagem.application.useCases.exceptions.AnaliseTriagemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class AnaliseExceptionHandler {
    private final AnaliseError analiseError = new AnaliseError();

    @ExceptionHandler(AnaliseTriagemException.class)
    public ResponseEntity<AnaliseError> trataErroDominio(AnaliseTriagemException e, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        analiseError.setTimestamp(Instant.now());
        analiseError.setStatus(status.value());
        analiseError.setError("Triagem inválida");
        analiseError.setMessage(e.getMessage());
        analiseError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(analiseError);
    }
}
