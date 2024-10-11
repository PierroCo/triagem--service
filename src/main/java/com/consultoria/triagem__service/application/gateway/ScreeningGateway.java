package com.consultoria.triagem__service.application.gateway;

import com.consultoria.triagem__service.application.domain.screening.Screening;
import java.util.Optional;

import java.util.UUID;

public interface ScreeningGateway {
    void deleteById(UUID id);
    Screening create(Screening newScreening);
    Optional<Screening> findById(UUID id);
    Screening update(Screening screening);
}
