package com.fross72.ecommerce.email;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmailConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmailRepository emailRepository){
        return args -> {
            Email email1 = new Email("1212@gmail.com");
            Email email2 = new Email("1213@gmail.com");
            emailRepository.saveAll(List.of(email1,email2));
        };
    }
}
