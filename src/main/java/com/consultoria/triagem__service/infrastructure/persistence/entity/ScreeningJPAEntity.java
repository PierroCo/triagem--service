package com.consultoria.triagem__service.infrastructure.persistence.entity;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;


import com.consultoria.triagem__service.application.domain.screening.Screening;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "screenings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class ScreeningJPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull(message = "User ID is required")
	@Column(nullable = false)
	private UUID userId;

	@NotBlank(message = "Profession is required")
	@Size(max = 100, message = "Profession must be up to 100 characters")
	@Column(nullable = false, length = 100)
	private String profession;

	@Size(max = 200, message = "LinkedIn profile link must be up to 200 characters")
	private String linkedin;

	@Size(max = 50, message = "Activity area must be up to 50 characters")
	private String activityArea;

	@Size(max = 100, message = "Current position must be up to 100 characters")
	private String currentPosition;

	@Size(max = 100, message = "Area of interest must be up to 100 characters")
	private String areaOfInterest;

	@Size(max = 100, message = "Desired position must be up to 100 characters")
	private String desiredPosition;

	@Positive(message = "Time to achieve goal must be a valid date.")
	private Date timeToAchieveGoal;

	@Builder.Default
	private Boolean active = true;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Instant createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Instant updatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Instant deletedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = Instant.now();
		updatedAt = createdAt;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = Instant.now();
	}

	public Screening toScreening() {
		return Screening.builder()
				.id(this.id)
				.userId(this.userId)
				.profession(this.profession)
				.linkedin(this.linkedin)
				.activityArea(this.activityArea)
				.currentPosition(this.currentPosition)
				.areaOfInterest(this.areaOfInterest)
				.desiredPosition(this.desiredPosition)
				.timeToAchieveGoal(this.timeToAchieveGoal)
				.build();
	}

	public static ScreeningJPAEntity from(Screening screening) {
		return ScreeningJPAEntity.builder()
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
