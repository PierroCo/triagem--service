package com.consultoria.triagem.infrastructure.persistence.repository;

import com.consultoria.triagem.application.domain.CargoHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoHabilidadeRepository extends JpaRepository<CargoHabilidade, Integer> {
    List<CargoHabilidade> findAllByCargoId(Integer id);
}
