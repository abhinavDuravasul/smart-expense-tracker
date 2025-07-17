package com.smart.expense.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilter {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/users/register").permitAll()
////                        .requestMatchers("/api/users/getAll").permitAll()
//                        .anyRequest().authenticated()).httpBasic();
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (useful for APIs)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // All requests need to be authenticated
                )
                .httpBasic(Customizer.withDefaults()); // Enable Basic Authentication

        return http.build();
    }


}
