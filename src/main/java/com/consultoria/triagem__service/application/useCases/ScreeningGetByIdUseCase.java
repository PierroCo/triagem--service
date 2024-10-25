package com.consultoria.triagem__service.application.useCases;

import com.consultoria.triagem__service.application.domain.exceptions.NotFoundException;
import com.consultoria.triagem__service.application.domain.screening.Screening;
import com.consultoria.triagem__service.application.gateway.ScreeningGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
public class ScreeningGetByIdUseCase {

    @NonNull
    private final ScreeningGateway screeningGateway;

    public Output execute(final UUID id) {
        return screeningGateway.findById(id)
                .map(Output::from)
                .orElseThrow(() -> new NotFoundException("Screening not found"));

    }

    public record Output(UUID id, UUID userId, String profession, String linkedin, String activityArea,
                         String currentPosition, String areaOfInterest, String desiredPosition,
                         String position, Date timeToAchieveGoal) {

        public static Output from(Screening screening) {
            return new Output(screening.getId(), screening.getUserId(), screening.getProfession(), screening.getLinkedin(), screening.getActivityArea(),
                    screening.getCurrentPosition(), screening.getCurrentPosition(), screening.getAreaOfInterest(), screening.getDesiredPosition(), screening.getTimeToAchieveGoal());
        }
    }
}






