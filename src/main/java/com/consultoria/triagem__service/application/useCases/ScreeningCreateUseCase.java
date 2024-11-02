package com.consultoria.triagem__service.application.useCases;

import com.consultoria.triagem__service.application.domain.screening.Screening;
import com.consultoria.triagem__service.application.gateway.ScreeningGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ScreeningCreateUseCase {
    @NonNull
    private final ScreeningGateway screeningGateway;


	public Output execute(final Input input){
       final var newScreening = Screening.newScreening(
               input.profession(), input.linkedin(), input.activityArea(), input.currentPosition(),
               input.areaOfInterest(), input.desiredPosition(), input.timeToAchieveGoal());

       final var screening = screeningGateway.create(newScreening);
       return Output.from(screening);
    }

    public record Input(UUID userId, String profession, String linkedin, String activityArea,
                        String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal){
    }
    public record Output(UUID id, UUID userId, String profession, String linkedin, String activityArea,
                        String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal){
        public static Output from (Screening screening){
            return new Output(screening.getId(), screening.getUserId(), screening.getProfession(), screening.getLinkedin(),
                    screening.getActivityArea(),screening.getCurrentPosition(), screening.getAreaOfInterest(),  screening.getDesiredPosition(),
                    screening.getTimeToAchieveGoal());
        }
    }
}
