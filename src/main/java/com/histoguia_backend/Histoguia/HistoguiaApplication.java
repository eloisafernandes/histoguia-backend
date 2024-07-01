package com.histoguia_backend.Histoguia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HistoguiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoguiaApplication.class, args);
	}

}
