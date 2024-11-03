package com.consultoria.triagem.model.input;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateScreeningDTO {
	private int age;
	private String profession;
	private String linkedin;
	private String activityArea;
	private String currentPosition;
	private String areaOfInterest;
	private String desiredPosition;
	private Date timeToAchieveGoal;
	private Date fillDate;
	private Date lastUpdate;
}
