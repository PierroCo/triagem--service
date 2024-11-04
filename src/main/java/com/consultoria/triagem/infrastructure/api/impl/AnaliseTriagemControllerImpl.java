package com.consultoria.triagem.infrastructure.api.impl;

import com.consultoria.triagem.application.useCases.AnalisarTriagemUseCase;
import com.consultoria.triagem.infrastructure.api.AnaliseTriagemController;
import com.consultoria.triagem.model.output.StatusAnaliseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class AnaliseTriagemControllerImpl implements AnaliseTriagemController {

    private final AnalisarTriagemUseCase analisarTriagemUseCase;

    @Override
    public ResponseEntity<StatusAnaliseOutput> analisarTriagem(@PathVariable UUID id) {
        var status = analisarTriagemUseCase.analisar(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
