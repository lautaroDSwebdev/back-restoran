//package com.example.demo.config;
//
//
//import com.example.demo.config.filters.JWTAuthenFilter;
//import com.example.demo.config.filters.JWTAuthorizFilter;
//import com.example.demo.config.security.JWTUtils;
//import com.example.demo.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableMethodSecurity(securedEnabled = true)
//public class SecurityConfig {
//
//    @Autowired
//    JWTUtils jwt_utils;
//
//    @Autowired
//    UserDetailsServiceImpl user_det_impl;
//
//    @Autowired
//    JWTAuthorizFilter jwt_autoriz_flter;
//
//
//    @Bean
//    public SecurityFilterChain filterChainConfig(HttpSecurity http, AuthenticationManager auth_manager) throws Exception {
//
//        JWTAuthenFilter jwt_auth_filter = new JWTAuthenFilter(jwt_utils);
//        jwt_auth_filter.setAuthenticationManager(auth_manager);
//        jwt_auth_filter.setFilterProcessesUrl("/login");
//
//        return http
//                .csrf(config -> config.disable())
//                .authorizeHttpRequests(auth -> {
//                            auth.requestMatchers("/login").permitAll();
//                            auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll();
////                            auth.requestMatchers(HttpMethod.POST, "/createUser").hasRole("ADMIN");
////                            auth.requestMatchers(HttpMethod.POST, "/createUser").hasRole("USER");
////                            auth.requestMatchers(HttpMethod.POST, "/createUser").hasRole("INVITED");
//                            auth.anyRequest().authenticated();
//                        }
//                )
//                .sessionManagement(session -> {
//                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                })
//                .httpBasic(Customizer.withDefaults())
//                .addFilter(jwt_auth_filter)
//                .addFilterBefore(jwt_autoriz_flter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//
//    //    esta Bean es especificamente para encriptacion de contraseñas
//    @Bean
//    PasswordEncoder contraseñaEncriptacion() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    AuthenticationManager autenticacionManejador(HttpSecurity http_secure, PasswordEncoder contraseñaEncriptacion) throws Exception {
//        return http_secure.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(user_det_impl)
//                .passwordEncoder(contraseñaEncriptacion)
//                .and().build();
//
//    }
//
//
//}