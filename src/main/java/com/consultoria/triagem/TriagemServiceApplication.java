package com.consultoria.triagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TriagemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriagemServiceApplication.class, args);
	}

}
