package com.example.Lab3D;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("nationality-app", r -> r
                        .path("/api/nationalities/{nationalityId}")
                        .or()
                        .path("/api/nationalities")
                        .uri("http://localhost:8082")
                )
                .route("player-app", r -> r
                        .path("/api/players")
                        .or()
                        .path("/api/players/{playerId}")
                        .or()
                        .path("/api/nationalities/{nationalityId}/players")
                        .uri("http://localhost:8081")
                )
                .build();
    }
}
