package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Erlaubt alle Endpunkte, die mit /api/ beginnen
                .allowedOrigins("*") // Ersetze mit dem tatsächlichen Ursprung deines Frontends
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false); // Falls du Cookies oder Auth-Header verwenden möchtest
        		
    }
}
