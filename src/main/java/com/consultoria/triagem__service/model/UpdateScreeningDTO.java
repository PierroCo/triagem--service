package com.consultoria.triagem__service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateScreeningDTO {

	private String profession;
	private String linkedin;
	private String activityArea;
	private String currentPosition;
	private String areaOfInterest;
	private String desiredPosition;
	private Date timeToAchieveGoal;

}
