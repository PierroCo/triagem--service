package com.consultoria.triagem.application.useCases.converter;

import com.consultoria.triagem.application.domain.screening.Screening;
import com.consultoria.triagem.infrastructure.persistence.entity.ScreeningEntity;
import com.consultoria.triagem.model.input.CreateScreeningDTO;
import com.consultoria.triagem.model.output.ScreeningDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ScreeningConverter {

    public Screening toDomain(CreateScreeningDTO createScreeningDTO) {
        return Screening.with(
                UUID.randomUUID(),
                createScreeningDTO.getUserId(),
                createScreeningDTO.getProfession(),
                createScreeningDTO.getLinkedin(),
                createScreeningDTO.getActivityArea(),
                createScreeningDTO.getCurrentPosition(),
                createScreeningDTO.getAreaOfInterest(),
                createScreeningDTO.getDesiredPosition(),
                createScreeningDTO.getTimeToAchieveGoal()
        );
    }

    public ScreeningDTO toDTO(Screening screening) {
        return ScreeningDTO.builder()
                .id(screening.getId())
                .userId(screening.getUserId())
                .profession(screening.getProfession())
                .linkedin(screening.getLinkedin())
                .activityArea(screening.getActivityArea())
                .currentPosition(screening.getCurrentPosition())
                .areaOfInterest(screening.getAreaOfInterest())
                .desiredPosition(screening.getDesiredPosition())
                .timeToAchieveGoal(screening.getTimeToAchieveGoal())
                .build();
    }

    public Screening toDomain(ScreeningEntity entity) {
        return Screening.with(
                entity.getId(),
                entity.getUserId(),
                entity.getProfession(),
                entity.getLinkedin(),
                entity.getActivityArea(),
                entity.getCurrentPosition(),
                entity.getAreaOfInterest(),
                entity.getDesiredPosition(),
                entity.getTimeToAchieveGoal()
        );
    }

    public ScreeningEntity toEntity(Screening screening) {
        return ScreeningEntity.builder()
                .id(screening.getId())
                .userId(screening.getUserId())
                .profession(screening.getProfession())
                .linkedin(screening.getLinkedin())
                .activityArea(screening.getActivityArea())
                .currentPosition(screening.getCurrentPosition())
                .areaOfInterest(screening.getAreaOfInterest())
                .desiredPosition(screening.getDesiredPosition())
                .timeToAchieveGoal(screening.getTimeToAchieveGoal())
                .build();
    }
}
