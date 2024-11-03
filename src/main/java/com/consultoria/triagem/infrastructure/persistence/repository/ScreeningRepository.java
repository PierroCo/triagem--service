package com.consultoria.triagem.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.consultoria.triagem.infrastructure.persistence.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningEntity, UUID> {
    Optional<ScreeningEntity> findByUserId(UUID userId);
}
