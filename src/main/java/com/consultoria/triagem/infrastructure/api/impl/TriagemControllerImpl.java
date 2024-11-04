package com.consultoria.triagem.infrastructure.api.impl;

import java.util.List;
import java.util.UUID;

import com.consultoria.triagem.application.useCases.TriagemUseCase;
import com.consultoria.triagem.infrastructure.api.TriagemController;
import com.consultoria.triagem.model.input.PreencherTriagemInput;
import com.consultoria.triagem.model.output.TriagemOutput;
import com.consultoria.triagem.model.input.UpdateTriagemInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TriagemControllerImpl implements TriagemController {

    private final TriagemUseCase triagemUseCase;

    @Override
    public ResponseEntity<TriagemOutput> preencherTriagem(final PreencherTriagemInput preencherTriagemInput) {
        TriagemOutput triagemCriada = triagemUseCase.criarTriagem(preencherTriagemInput);
        return new ResponseEntity<>(triagemCriada, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TriagemOutput> getTriagemById(UUID id) {
        TriagemOutput triagem = triagemUseCase.getTriagemById(id);
        if (triagem != null) {
            return ResponseEntity.ok(triagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<TriagemOutput>> getTriagensByUserId(UUID userId) {
        List<TriagemOutput> triagens = triagemUseCase.getTriagemByUserId(userId);
        if (!triagens.isEmpty()) {
            return ResponseEntity.ok(triagens);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<TriagemOutput> updateTriagemById(UUID id, UpdateTriagemInput updateTriagemInput) {
        TriagemOutput updatedTriagemInput = triagemUseCase.updateTriagem(id, updateTriagemInput);
        return new ResponseEntity<>(updatedTriagemInput, HttpStatus.OK);
    }
}
