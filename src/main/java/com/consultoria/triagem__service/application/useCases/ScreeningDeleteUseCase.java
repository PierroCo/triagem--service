package com.consultoria.triagem__service.application.useCases;

import com.consultoria.triagem__service.application.gateway.ScreeningGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ScreeningDeleteUseCase {

    @NonNull
    private final ScreeningGateway screeningGateway;

    public void execute(final UUID id) {
        screeningGateway.deleteById(id);
    }
}