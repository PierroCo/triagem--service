package com.consultoria.triagem__service.infrastructure.api;

import com.consultoria.triagem__service.model.CreateScreeningDTO;
import com.consultoria.triagem__service.model.ScreeningDTO;
import com.consultoria.triagem__service.model.UpdateScreeningDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ScreeningsApi {

	@PostMapping("/screenings")
	ResponseEntity<ScreeningDTO> createScreening(@RequestBody CreateScreeningDTO body);

	@DeleteMapping("/screenings/{id}")
	ResponseEntity<Void> deleteScreeningById(@PathVariable UUID id);

	@GetMapping("/screenings/{id}")
	ResponseEntity<ScreeningDTO> getScreeningById(@PathVariable UUID id);

	@PutMapping("/screenings/{id}")
	ResponseEntity<ScreeningDTO> updateScreeningById(@PathVariable UUID id, UUID userId, @RequestBody UpdateScreeningDTO body);
}
