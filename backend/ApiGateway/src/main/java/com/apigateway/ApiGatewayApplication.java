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
                .route("PartnershipManagement", r -> r.path("/Partnership/partnerships/**")
                        .uri("lb://PartnershipManagement"))
                .route("PartnershipManagement", r -> r.path("/Partnership/entreprises/**")
                        .uri("lb://PartnershipManagement"))
                .route("PartnershipManagement", r -> r.path("/Partnership/proposals/**")
                        .uri("lb://PartnershipManagement"))
                .route("hackathon-Management", r -> r.path("/api/hackathons/**")
                        .uri("lb://backend2"))

                // 🔹 Séances de coaching
                .route("coaching-Management", r -> r.path("/api/seances/**")
                        .uri("lb://backend2"))
                .build();
    }


}
