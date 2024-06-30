package com.histoguia_backend.Histoguia.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Aplica a configuração para todos os endpoints /api/**
                .allowedOrigins("http://localhost:3000") // Permitir requisições apenas de http://localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Todos os cabeçalhos permitidos
                .allowCredentials(true); // Permitir envio de credenciais (cookies, por exemplo)
    }
}