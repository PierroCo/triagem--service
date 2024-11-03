package com.consultoria.triagem.infrastructure.api.impl;

import java.net.URI;
import java.util.UUID;

import com.consultoria.triagem.application.useCases.ScreeningUseCase;
import com.consultoria.triagem.infrastructure.api.ScreeningController;
import com.consultoria.triagem.model.input.CreateScreeningDTO;
import com.consultoria.triagem.model.output.ScreeningDTO;
import com.consultoria.triagem.model.input.UpdateScreeningDTO;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScreeningControllerImpl implements ScreeningController {

    private final ScreeningUseCase screeningUseCase;

    @Override
    public ResponseEntity<ScreeningDTO> createScreening(final CreateScreeningDTO createScreeningDTO) {
        ScreeningDTO createdScreening = screeningUseCase.makeScreening(createScreeningDTO);
        URI location = URI.create("/screening/" + createdScreening.getId());

        return ResponseEntity.created(location).body(createdScreening);
    }

    @Override
    public ResponseEntity<ScreeningDTO> getScreeningById(UUID id) {
        ScreeningDTO screening = screeningUseCase.getScreeningById(id);
        if (screening != null) {
            return ResponseEntity.ok(screening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ScreeningDTO> getScreeningByUserId(UUID userId) {
        ScreeningDTO screening = screeningUseCase.getScreeningByUserId(userId);
        if (screening != null) {
            return ResponseEntity.ok(screening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ScreeningDTO> updateScreeningById(UUID id, UpdateScreeningDTO body) {
        ScreeningDTO updatedScreening = screeningUseCase.updateScreening(id, body);
        if (updatedScreening != null) {
            return ResponseEntity.ok(updatedScreening);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
