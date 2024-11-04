package com.consultoria.triagem.infrastructure.api;

import com.consultoria.triagem.model.output.StatusAnaliseOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/analise")
public interface AnaliseTriagemController {
    @PostMapping("/{id}")
    ResponseEntity<StatusAnaliseOutput> analisarTriagem(@PathVariable UUID id);
}