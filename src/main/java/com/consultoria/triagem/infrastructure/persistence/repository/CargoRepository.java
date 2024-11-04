package com.consultoria.triagem.infrastructure.persistence.repository;

import com.consultoria.triagem.application.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
