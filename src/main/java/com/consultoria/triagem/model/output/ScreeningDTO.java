package com.consultoria.triagem.model.output;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class ScreeningDTO {
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
