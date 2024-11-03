package com.consultoria.triagem.infrastructure.api;

import com.consultoria.triagem.model.input.CreateScreeningDTO;
import com.consultoria.triagem.model.output.ScreeningDTO;
import com.consultoria.triagem.model.input.UpdateScreeningDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/screening")
public interface ScreeningsController {

	@PostMapping
	ResponseEntity<ScreeningDTO> createScreening(@RequestBody CreateScreeningDTO body);

	@GetMapping("/{id}")
	ResponseEntity<ScreeningDTO> getScreeningById(@PathVariable UUID id);

	@GetMapping("/user/{id}")
	ResponseEntity<ScreeningDTO> getScreeningByUserId(@PathVariable UUID id);

	@PutMapping("/{id}")
	ResponseEntity<ScreeningDTO> updateScreeningById(@PathVariable UUID id, @RequestBody UpdateScreeningDTO body);
}
