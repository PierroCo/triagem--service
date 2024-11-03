package com.consultoria.triagem.application.domain.screening;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Screening {
    UUID id;
    UUID userId;
    String profession;
    String linkedin;
    String activityArea;
    String currentPosition;
    String areaOfInterest;
    String desiredPosition;
    Date timeToAchieveGoal;

    public Screening(final String profession, final String linkedin, final String activityArea,
                     final String currentPosition, final String areaOfInterest, final String desiredPosition, final Date timeToAchieveGoal) {
        this.profession = profession;
        this.linkedin = linkedin;
        this.activityArea = activityArea;
        this.currentPosition = currentPosition;
        this.areaOfInterest = areaOfInterest;
        this.desiredPosition = desiredPosition;
        this.timeToAchieveGoal = timeToAchieveGoal;
    }

    public Screening(final UUID id, final UUID userId, final String profession, final String linkedin, final String activityArea,
                     final String currentPosition, final String areaOfInterest, final String desiredPosition, final Date timeToAchieveGoal) {

        this.id = id;
        this.userId = userId;
        this.profession = profession;
        this.linkedin = linkedin;
        this.activityArea = activityArea;
        this.currentPosition = currentPosition;
        this.areaOfInterest = areaOfInterest;
        this.desiredPosition = desiredPosition;
        this.timeToAchieveGoal = timeToAchieveGoal;
    }

    public static Screening newScreening(final String profession, final String linkedin, final String activityArea,
                                         final String currentPosition, final String areaOfInterest, final String desiredPosition, final Date timeToAchieveGoal) {
        return new Screening(profession, linkedin, activityArea, currentPosition, areaOfInterest, desiredPosition, timeToAchieveGoal);
    }

    public Screening update(final String profession, final String linkedin, final String activityArea,
                            final String currentPosition, final String areaOfInterest, final String desiredPosition, final Date timeToAchieveGoal) {
        this.profession = profession;
        this.linkedin = linkedin;
        this.activityArea = activityArea;
        this.currentPosition = currentPosition;
        this.areaOfInterest = areaOfInterest;
        this.desiredPosition = desiredPosition;
        this.timeToAchieveGoal = timeToAchieveGoal;

        return this;
    }
    public static Screening with(final UUID id, final UUID userId, final String profession, final String linkedin, final String activityArea,
                                 final String currentPosition, final String areaOfInterest, final String desiredPosition, final Date timeToAchieveGoal){
        return new Screening(id, userId,profession, linkedin, activityArea, currentPosition, areaOfInterest, desiredPosition, timeToAchieveGoal);
    }
}


