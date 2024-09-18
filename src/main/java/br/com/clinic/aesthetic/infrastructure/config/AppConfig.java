package br.com.clinic.aesthetic.infrastructure.config;

import br.com.clinic.aesthetic.application.ports.input.UserUseCase;
import br.com.clinic.aesthetic.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Bean
    CommandLineRunner initDatabase(UserUseCase userUseCase, BCryptPasswordEncoder passwordEncoder){
        return args -> {
            if (userUseCase.findUserByEmail(adminEmail).isEmpty()){
                User admin = new User();
                admin.setName("admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                userUseCase.createUser(admin);
                System.out.println("Admin user created successfully.");

            } else {
                System.out.println("Admin user already exists.");
            }
        };
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
