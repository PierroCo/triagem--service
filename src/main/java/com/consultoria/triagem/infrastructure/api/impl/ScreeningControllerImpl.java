package com.consultoria.triagem.infrastructure.api.impl;


import java.net.URI;
import java.util.UUID;


import com.consultoria.triagem.application.useCases.ScreeningUseCase;
import com.consultoria.triagem.infrastructure.api.ScreeningsController;
import com.consultoria.triagem.model.input.CreateScreeningDTO;
import com.consultoria.triagem.model.output.ScreeningDTO;
import com.consultoria.triagem.model.input.UpdateScreeningDTO;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScreeningControllerImpl implements ScreeningsController {

    private final ScreeningUseCase screeningUseCase;

    @Override
    public ResponseEntity<ScreeningDTO> createScreening(final CreateScreeningDTO createScreeningDTO) {
        System.out.println("Entrou na controller");

        ScreeningDTO makeScreening = screeningUseCase.makeScreening(createScreeningDTO);
//        final var uri = URI.create("/screenings/" + makeScreening.id());

        return ResponseEntity.ok(makeScreening); //TODO Alterar para created 201
//
//        final var newScreening = new ScreeningCreateUseCase.Input(body.getUserId(), body.getProfession(), body.getLinkedin(),
//                body.getActivityArea(), body.getCurrentPosition(), body.getAreaOfInterest(), body.getDesiredPosition(),
//                body.getTimeToAchieveGoal());
//        final var createdScreening = screeningCreateUseCase.execute(newScreening);
//
//        final var response = new ScreeningDTO()
//                .id(createdScreening.id())
//                .userId(createdScreening.userId())
//                .profession(createdScreening.profession())
//                .linkedin(createdScreening.linkedin())
//                .activityArea(createdScreening.activityArea())
//                .currentPosition(createdScreening.currentPosition())
//                .areaOfInterest(createdScreening.areaOfInterest())
//                .desiredPosition(createdScreening.desiredPosition())
//                .timeToAchieveGoal(createdScreening.timeToAchieveGoal());
//        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<ScreeningDTO> getScreeningById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<ScreeningDTO> getScreeningByUserId(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<ScreeningDTO> updateScreeningById(UUID id, UpdateScreeningDTO body) {
        return null;
    }

//    @Override
//    public ResponseEntity<ScreeningDTO> getScreeningById(final UUID id) {
//        ScreeningGetByIdUseCase.Output output = screeningGetByIdUseCase.execute(id);
//        final var response = new ScreeningDTO()
//                .id(output.id())
//                .userId(output.userId())
//                .profession(output.profession())
//                .linkedin(output.linkedin())
//                .activityArea(output.activityArea())
//                .currentPosition(output.currentPosition())
//                .areaOfInterest(output.areaOfInterest())
//                .desiredPosition(output.desiredPosition())
//                .timeToAchieveGoal(output.timeToAchieveGoal());
//        return ResponseEntity.ok(response);
//    }
//
//    @Override
//    public ResponseEntity<ScreeningDTO> getScreeningByUserId(final UUID id) {
//        ScreeningGetByIdUseCase.Output output = screeningGetByIdUseCase.execute(id);
//        final var response = new ScreeningDTO()
//                .id(output.id())
//                .userId(output.userId())
//                .profession(output.profession())
//                .linkedin(output.linkedin())
//                .activityArea(output.activityArea())
//                .currentPosition(output.currentPosition())
//                .areaOfInterest(output.areaOfInterest())
//                .desiredPosition(output.desiredPosition())
//                .timeToAchieveGoal(output.timeToAchieveGoal());
//        return ResponseEntity.ok(response);
//    }
//
//    @Override
//    public ResponseEntity<ScreeningDTO> updateScreeningById(final UUID id, final UUID userId, final UpdateScreeningDTO body) {
//        final var input = new ScreeningUpdateUseCase.Input(id, userId, body.getProfession(), body.getLinkedin(), body.getActivityArea(),
//                body.getCurrentPosition(), body.getAreaOfInterest(), body.getDesiredPosition(), body.getTimeToAchieveGoal());
//        final var output = screeningUpdateUseCase.execute(input);
//        final var response = new ScreeningDTO()
//                .id(output.id())
//                .userId(output.userId())
//                .profession(output.profession())
//                .linkedin(output.linkedin())
//                .activityArea(output.activityArea())
//                .currentPosition(output.currentPosition())
//                .areaOfInterest(output.areaOfInterest())
//                .desiredPosition(output.desiredPosition())
//                .timeToAchieveGoal(output.timeToAchieveGoal());
//        return ResponseEntity.ok(response);
//    }
}
