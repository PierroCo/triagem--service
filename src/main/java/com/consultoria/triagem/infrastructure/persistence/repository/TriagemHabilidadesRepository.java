package com.consultoria.triagem.infrastructure.persistence.repository;

import com.carrerexpansion.gestao_triagem.core.domain.TriagemHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TriagemHabilidadesRepository extends JpaRepository<TriagemHabilidades, Integer> {
    List<TriagemHabilidades> findAllByTriagemIs(UUID id);
}
