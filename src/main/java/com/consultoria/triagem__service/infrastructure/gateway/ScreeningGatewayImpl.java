package com.consultoria.triagem__service.infrastructure.gateway;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.consultoria.triagem__service.application.domain.screening.Screening;
import com.consultoria.triagem__service.application.gateway.ScreeningGateway;
import com.consultoria.triagem__service.infrastructure.persistence.entity.ScreeningJPAEntity;
import com.consultoria.triagem__service.infrastructure.persistence.repository.ScreeningJPARepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScreeningGatewayImpl implements ScreeningGateway {

	@NonNull
	private final ScreeningJPARepository screeningJPARepository;

	@Override
	@Transactional
	public void deleteById(UUID id) {
		screeningJPARepository.deleteById(id);
	}

	@Override
	@Transactional
	public Screening create(final Screening newScreening) {
		return save(newScreening);
	}

	@Override
	public Optional<Screening> findById(UUID id) {
		return screeningJPARepository.findById(id).map(ScreeningJPAEntity::toScreening);
	}

	@Override
	@Transactional
	public Screening update(final Screening screening) {
		return save(screening);
	}

	private Screening save(final Screening screening) {
		return screeningJPARepository.save(ScreeningJPAEntity.from(screening)).toScreening();
	}
}
