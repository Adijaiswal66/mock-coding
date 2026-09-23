package com.aditya.mockcoding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/auth/**").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/employees/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/employees/**").hasAnyRole("ADMIN","EMPLOYEE")
                                .anyRequest().authenticated()
                )
                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return httpSecurity.build();
    }


}
