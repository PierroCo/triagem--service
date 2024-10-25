package com.consultoria.triagem__service.application.useCases;

import com.consultoria.triagem__service.application.domain.exceptions.NotFoundException;
import com.consultoria.triagem__service.application.domain.screening.Screening;
import com.consultoria.triagem__service.application.gateway.ScreeningGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
public class ScreeningUpdateUseCase {

    @NonNull
    private final ScreeningGateway screeningGateway;

    public Output execute(final Input input) {
        final var screening = screeningGateway.findById(input.id())
                .orElseThrow(() -> new NotFoundException("Screening not found"));

        screening.update(input.profession, input.linkedin, input.activityArea, input.currentPosition, input.areaOfInterest,
                input.desiredPosition, input.timeToAchieveGoal);
        screeningGateway.update(screening);

        return Output.from(screening);
    }

    public record Input(UUID id,UUID userId, String profession, String linkedin, String activityArea,
                        String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal) {

    }

    public record Output(UUID id,UUID userId, String profession, String linkedin, String activityArea,
                         String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal) {

        public static Output from(final Screening screening) {
            return new Output(screening.getId(), screening.getUserId(), screening.getProfession(), screening.getLinkedin(), screening.getActivityArea(), screening.getCurrentPosition(), screening.getAreaOfInterest(),
                    screening.getDesiredPosition(), screening.getTimeToAchieveGoal());
        }

    }
}
