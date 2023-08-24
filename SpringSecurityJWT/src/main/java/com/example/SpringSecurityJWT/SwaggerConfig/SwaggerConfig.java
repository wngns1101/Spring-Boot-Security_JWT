package com.example.SpringSecurityJWT.SwaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@OpenAPIDefinition(
//        info = @Info(title = "Swagger test 명세서",
//                description = "쇼핑몰 api 명세서",
//                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("authorization", new SecurityScheme()
                                .name("authorization")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("authorization"))
                .info(new Info()
                        .title("스프링시큐리티 + JWT 예제")
                        .description("스프링시큐리티 예제.")
                        .version("1.0.0"));
        }
    }

//    @Bean
//    public GroupedOpenApi chatOpenApi() {
//        String[] paths = {"/**"};
//
//        return GroupedOpenApi.builder()
//                .group("쇼핑몰 api v1")
//                .pathsToMatch(paths)
//                .build();