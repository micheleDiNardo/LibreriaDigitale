package com.example.LibreriaDigitale.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class HttpConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Consentire tutte le origini (aggiusta in base alle tue esigenze di sicurezza)
        config.addAllowedMethod("*"); // Consentire tutti i metodi HTTP
        config.addAllowedHeader("*"); // Consentire tutte le intestazioni HTTP
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
