package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                //  Hackathons
                .route("hackathon-route", r -> r.path("/api/hackathons/**")
                        .uri("lb://backend2"))

                //  Participations
                .route("participation-route", r -> r.path("/api/participations/**")
                        .uri("lb://backend2"))

                //  Séances de coaching
                .route("seance-route", r -> r.path("/api/seances/**")
                        .uri("lb://backend2"))

                //  Utilisateurs
                .route("user-route", r -> r.path("/api/v1/users/**")
                        .uri("lb://backend2"))

                .build();
    }


}
