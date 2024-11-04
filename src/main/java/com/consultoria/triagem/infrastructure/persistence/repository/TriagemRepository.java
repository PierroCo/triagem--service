package com.consultoria.triagem.infrastructure.persistence.repository;


import com.consultoria.triagem.application.domain.Triagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TriagemRepository extends JpaRepository<Triagem, UUID> {
    Optional<Triagem> findByUsuarioId(UUID usuarioId);
}