package com.consultoria.triagem__service.infrastructure.api.impl;


import java.net.URI;
import java.util.UUID;

import com.consultoria.triagem__service.application.useCases.ScreeningCreateUseCase;
import com.consultoria.triagem__service.application.useCases.ScreeningGetByIdUseCase;
import com.consultoria.triagem__service.application.useCases.ScreeningUpdateUseCase;
import com.consultoria.triagem__service.infrastructure.api.ScreeningsController;
import com.consultoria.triagem__service.model.input.CreateScreeningDTO;
import com.consultoria.triagem__service.model.output.ScreeningDTO;
import com.consultoria.triagem__service.model.input.UpdateScreeningDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ScreeningControllerImpl implements ScreeningsController {

	@NonNull
	private final ScreeningCreateUseCase screeningCreateUseCase;

	@NonNull
	private final ScreeningGetByIdUseCase screeningGetByIdUseCase;

	@NonNull
	private final ScreeningUpdateUseCase screeningUpdateUseCase;

	@Override
	public ResponseEntity<ScreeningDTO> createScreening(final CreateScreeningDTO body) {
		final var newScreening = new ScreeningCreateUseCase.Input(body.getUserId(), body.getProfession(), body.getLinkedin(),
				body.getActivityArea(), body.getCurrentPosition(), body.getAreaOfInterest(), body.getDesiredPosition(),
				body.getTimeToAchieveGoal());
		final var createdScreening = screeningCreateUseCase.execute(newScreening);
		final var uri = URI.create("/screenings/" + createdScreening.id());
		final var response = new ScreeningDTO()
				.id(createdScreening.id())
				.userId(createdScreening.userId())
				.profession(createdScreening.profession())
				.linkedin(createdScreening.linkedin())
				.activityArea(createdScreening.activityArea())
				.currentPosition(createdScreening.currentPosition())
				.areaOfInterest(createdScreening.areaOfInterest())
				.desiredPosition(createdScreening.desiredPosition())
				.timeToAchieveGoal(createdScreening.timeToAchieveGoal());
		return ResponseEntity.created(uri).body(response);
	}

	@Override
	public ResponseEntity<ScreeningDTO> getScreeningById(final UUID id) {
		ScreeningGetByIdUseCase.Output output = screeningGetByIdUseCase.execute(id);
		final var response = new ScreeningDTO()
				.id(output.id())
				.userId(output.userId())
				.profession(output.profession())
				.linkedin(output.linkedin())
				.activityArea(output.activityArea())
				.currentPosition(output.currentPosition())
				.areaOfInterest(output.areaOfInterest())
				.desiredPosition(output.desiredPosition())
				.timeToAchieveGoal(output.timeToAchieveGoal());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<ScreeningDTO> getScreeningByUserId(final UUID id) {
		ScreeningGetByIdUseCase.Output output = screeningGetByIdUseCase.execute(id);
		final var response = new ScreeningDTO()
				.id(output.id())
				.userId(output.userId())
				.profession(output.profession())
				.linkedin(output.linkedin())
				.activityArea(output.activityArea())
				.currentPosition(output.currentPosition())
				.areaOfInterest(output.areaOfInterest())
				.desiredPosition(output.desiredPosition())
				.timeToAchieveGoal(output.timeToAchieveGoal());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<ScreeningDTO> updateScreeningById(final UUID id, final UUID userId, final UpdateScreeningDTO body) {
		final var input = new ScreeningUpdateUseCase.Input(id,userId, body.getProfession(), body.getLinkedin(), body.getActivityArea(),
				body.getCurrentPosition(), body.getAreaOfInterest(), body.getDesiredPosition(), body.getTimeToAchieveGoal());
		final var output = screeningUpdateUseCase.execute(input);
		final var response = new ScreeningDTO()
				.id(output.id())
				.userId(output.userId())
				.profession(output.profession())
				.linkedin(output.linkedin())
				.activityArea(output.activityArea())
				.currentPosition(output.currentPosition())
				.areaOfInterest(output.areaOfInterest())
				.desiredPosition(output.desiredPosition())
				.timeToAchieveGoal(output.timeToAchieveGoal());
		return ResponseEntity.ok(response);
	}
}
