package com.consultoria.triagem__service.infrastructure.api;

import com.consultoria.triagem__service.model.input.CreateScreeningDTO;
import com.consultoria.triagem__service.model.output.ScreeningDTO;
import com.consultoria.triagem__service.model.input.UpdateScreeningDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/screening")
public interface ScreeningsController {

	@PostMapping
	ResponseEntity<ScreeningDTO> createScreening(@RequestBody CreateScreeningDTO body);

	@GetMapping("/{id}")
	ResponseEntity<ScreeningDTO> getScreeningById(@PathVariable UUID id);

	@GetMapping("/{id}")
	ResponseEntity<ScreeningDTO> getScreeningByUserId(@PathVariable UUID id);

	@PutMapping("/{id}")
	ResponseEntity<ScreeningDTO> updateScreeningById(@PathVariable UUID id, UUID userId, @RequestBody UpdateScreeningDTO body);
}
