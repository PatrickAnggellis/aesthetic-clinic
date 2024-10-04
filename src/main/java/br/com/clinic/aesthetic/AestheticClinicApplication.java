package br.com.clinic.aesthetic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
public class AestheticClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AestheticClinicApplication.class, args);
	}

}
