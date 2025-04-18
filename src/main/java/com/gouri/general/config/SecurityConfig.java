package com.gouri.general.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)// Disable CSRF protection for simplicity
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/admin/**").hasRole("Admin")
                    .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/public/**").permitAll().anyRequest().authenticated()
            )
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults()).build();
    }

}
