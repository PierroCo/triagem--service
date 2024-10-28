package com.consultoria.triagem__service.infrastructure.config;

import com.consultoria.triagem__service.application.gateway.ScreeningGateway;
import com.consultoria.triagem__service.infrastructure.gateway.ScreeningGatewayImpl;
import com.consultoria.triagem__service.infrastructure.persistence.repository.ScreeningJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

	@Bean
	ScreeningGateway screeningGateway(final ScreeningJPARepository screeningJPARepository) {
		return new ScreeningGatewayImpl(screeningJPARepository);
	}
}
