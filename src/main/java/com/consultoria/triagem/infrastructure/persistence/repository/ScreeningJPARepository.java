package com.consultoria.triagem.infrastructure.persistence.repository;

import java.util.UUID;

import com.consultoria.triagem.infrastructure.persistence.entity.ScreeningJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningJPARepository extends JpaRepository<ScreeningJPAEntity, UUID> {
}
