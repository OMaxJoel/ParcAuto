package com.ccc.parcauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ParcautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcautoApplication.class, args);
	}

}
