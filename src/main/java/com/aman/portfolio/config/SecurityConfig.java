package com.aman.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
                // Keep CSRF enabled for the admin dashboard.
                // The public contact form sends JSON to this endpoint.
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/contacts")
                )

                .authorizeHttpRequests(auth -> auth

                        // Public website and login page
                        .requestMatchers(
                                "/",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/favicon.ico",
                                "/admin/login",
                                "/error"
                        ).permitAll()

                        // Dashboard is admin-only
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        // Anyone can submit the public contact form
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/contacts"
                        ).permitAll()

                        // Only admin can retrieve contact messages
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/contacts",
                                "/api/contacts/**"
                        ).hasRole("ADMIN")

                        // Deny everything else by default
                        .anyRequest().denyAll()
                )

                .formLogin(form -> form
                        .loginPage("/admin/login")
                        .defaultSuccessUrl(
                                "/admin/messages",
                                true
                        )
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/admin/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}