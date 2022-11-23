package com.DH.DigitalBooking.config.app;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;



@Configuration
public class AppResourceConfig {

    //MODEL MAPPER PARA HACER CASTEO
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    //Error que le salía por Spring Security Create Session
    //Permiso para poder usar todas las capas metodos put delete ect
    //LOS BEAN permiten inyectar y hacer una sola instancia (PATRON SINGLETON)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository())

                .requireCsrfProtectionMatcher(

                        httpServletRequest->httpServletRequest.getMethod().equals("None")

                );

        return http.build();
    }
}
