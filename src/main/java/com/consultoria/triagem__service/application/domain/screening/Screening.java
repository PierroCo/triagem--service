package com.consultoria.triagem__service.application.domain.screening;

import java.util.Date;
import java.util.UUID;

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

    public Screening(UUID id, UUID userId, String profession, String linkedin, String activityArea, String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getActivityArea() {
        return activityArea;
    }

    public void setActivityArea(String activityArea) {
        this.activityArea = activityArea;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public String getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(String desiredPosition) {
        this.desiredPosition = desiredPosition;
    }

    public Date getTimeToAchieveGoal() {
        return timeToAchieveGoal;
    }

    public void setTimeToAchieveGoal(Date timeToAchieveGoal) {
        this.timeToAchieveGoal = timeToAchieveGoal;
    }
}
