package com.avanade.avanade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AvanadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvanadeApplication.class, args);
	}

}
