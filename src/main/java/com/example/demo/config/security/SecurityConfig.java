package com.example.demo.config.security;


import com.example.demo.config.filters.JWTAuthenFilter;
import com.example.demo.config.filters.JWTAuthorizationFilter;
import com.example.demo.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetServimpl;
    @Autowired
    JwtUtilsClass jwt_ut;

    @Autowired
    JWTAuthorizationFilter jwt_author;

    @Bean
    public SecurityFilterChain filterChainConfig(HttpSecurity http, AuthenticationManager auth_manager) throws Exception {

        JWTAuthenFilter jwtAuthFil = new JWTAuthenFilter(jwt_ut);
        jwtAuthFil.setAuthenticationManager(auth_manager);
        jwtAuthFil.setFilterProcessesUrl("/login");

        return http
                .csrf(config -> config.disable())
                .authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/auth/**").permitAll();
                            auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll();
//                            auth.requestMatchers(HttpMethod.POST, "/createUser").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.POST, "/createUser").hasRole("USER");
//                            auth.requestMatchers(HttpMethod.POST, "/createUser").hasRole("INVITED");
                            auth.anyRequest().authenticated();
                        }
                )
//
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
//                las validaciones del token en los filtros de autenticacion
                .addFilter(jwtAuthFil)
                .addFilterBefore(jwt_author, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

////        Esto es para crear un usuario en memoria
//    @Bean
//    UserDetailsService userDetServ() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("santiago")
//                .password("5423")
//                .roles()
//                .build());
//        return manager;
//    }


    //    esta Bean es especificamente para encriptacion de contraseñas
    @Bean
    PasswordEncoder contraseñaEncriptacion() {
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity h, PasswordEncoder p) throws Exception {
        return h.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetServimpl)
                .passwordEncoder(p)
                .and().build();
    }


//    public static void main(String[] args) {
//        System.out.println( new BCryptPasswordEncoder().encode("hola654") );
//    }
//    hola654
//$2a$10$aXORnpAgQNEwex4XflN2yen6JgmkHwDqp6zEOZOD1XlzAUDvyzce.
}