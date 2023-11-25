package com.example.Lab3D.nationality.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean(name = "nationalityRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}