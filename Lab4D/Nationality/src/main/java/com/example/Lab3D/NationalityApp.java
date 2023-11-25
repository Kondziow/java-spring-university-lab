package com.example.Lab3D;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NationalityApp {

	public static void main(String[] args) {
		SpringApplication.run(NationalityApp.class, args);
	}

	@Bean
	public RestTemplate restTemplate(@Value("http://localhost:8081") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}

}
