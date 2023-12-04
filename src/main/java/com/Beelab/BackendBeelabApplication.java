package com.Beelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Beelab")
public class BackendBeelabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBeelabApplication.class, args);
	}

}
