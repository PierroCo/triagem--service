package com.consultoria.triagem.infrastructure.api;

import com.consultoria.triagem.model.input.PreencherTriagemInput;
import com.consultoria.triagem.model.output.TriagemOutput;
import com.consultoria.triagem.model.input.UpdateTriagemInput;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/triagem")
public interface TriagemController {
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<TriagemOutput> preencherTriagem(@RequestBody PreencherTriagemInput body);

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<TriagemOutput> getTriagemById(@PathVariable UUID id);

	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<TriagemOutput>> getTriagensByUserId(@PathVariable UUID userId);

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<TriagemOutput> updateTriagemById(@PathVariable UUID id, @RequestBody UpdateTriagemInput body);
}
