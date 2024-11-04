package com.consultoria.triagem.infrastructure.api;

import com.consultoria.triagem.model.output.StatusAnaliseOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/analise")
public interface AnaliseTriagemController {
    @GetMapping("/{id}")
    ResponseEntity<StatusAnaliseOutput> analisarTriagem(@PathVariable UUID id);
}