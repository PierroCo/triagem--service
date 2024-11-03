package com.consultoria.triagem.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateScreeningDTO {
	private int age;
	private String profession;
	private String linkedin;
	private String activityArea;
	private String currentPosition;
	private String areaOfInterest;
	private String desiredPosition;
	private Date timeToAchieveGoal;
}
