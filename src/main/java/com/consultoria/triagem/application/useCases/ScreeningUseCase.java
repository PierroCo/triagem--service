package com.consultoria.triagem.application.useCases;

import com.consultoria.triagem.application.domain.exceptions.ScreeningNotFoundException;
import com.consultoria.triagem.application.domain.screening.Screening;
import com.consultoria.triagem.application.useCases.converter.ScreeningConverter;
import com.consultoria.triagem.infrastructure.persistence.entity.ScreeningEntity;
import com.consultoria.triagem.infrastructure.persistence.repository.ScreeningRepository;
import com.consultoria.triagem.model.input.CreateScreeningDTO;
import com.consultoria.triagem.model.input.UpdateScreeningDTO;
import com.consultoria.triagem.model.output.ScreeningDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ScreeningUseCase {

    private final ScreeningConverter screeningConverter;
    private final ScreeningRepository screeningRepository;

    public ScreeningDTO makeScreening(CreateScreeningDTO createScreeningDTO) {
        Screening screening = screeningConverter.toDomain(createScreeningDTO);
        ScreeningEntity entityToSave = ScreeningEntity.from(screening);
        ScreeningEntity savedEntity = screeningRepository.save(entityToSave);
        return screeningConverter.toDTO(savedEntity.toScreening());
    }

    public ScreeningDTO getScreeningById(UUID id) {
        return screeningRepository.findById(id)
                .map(ScreeningEntity::toScreening)
                .map(screeningConverter::toDTO)
                .orElseThrow(() -> new ScreeningNotFoundException("Screening not found with ID: " + id));
    }

    public ScreeningDTO getScreeningByUserId(UUID userId) {
        Optional<ScreeningEntity> screeningEntityOptional = screeningRepository.findByUserId(userId);
        return screeningEntityOptional
                .map(screeningEntity -> screeningEntity.toScreening())
                .map(screeningConverter::toDTO)
                .orElseThrow(() -> new ScreeningNotFoundException("Screening not found for User ID: " + userId));
    }

    public ScreeningDTO updateScreening(UUID id, UpdateScreeningDTO updateScreeningDTO) {
        return screeningRepository.findById(id).map(existingEntity -> {
            existingEntity.setProfession(updateScreeningDTO.getProfession());
            existingEntity.setLinkedin(updateScreeningDTO.getLinkedin());
            existingEntity.setActivityArea(updateScreeningDTO.getActivityArea());
            existingEntity.setCurrentPosition(updateScreeningDTO.getCurrentPosition());
            existingEntity.setAreaOfInterest(updateScreeningDTO.getAreaOfInterest());
            existingEntity.setDesiredPosition(updateScreeningDTO.getDesiredPosition());
            existingEntity.setTimeToAchieveGoal(updateScreeningDTO.getTimeToAchieveGoal());

            ScreeningEntity updatedEntity = screeningRepository.save(existingEntity);
            return screeningConverter.toDTO(updatedEntity.toScreening());
        }).orElse(null);
    }

}
