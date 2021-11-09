package com.sample.traktruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TraktruckApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraktruckApplication.class, args);
	}

}
