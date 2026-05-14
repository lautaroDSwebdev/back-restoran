package com.example.demo;

import com.example.demo.enums.ERole;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    PasswordEncoder passw_encoder;

    @Autowired
    UserRepository user_repo;

//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//           UsersEntity user_ent = UsersEntity.builder()
//                   .email("guillermo2@gmail.com")
//                   .username("guillermo2")
//                   .password(passw_encoder.encode("7654747"))
//                   .roles(Set.of(RoleEntity.builder()
//                           .name(ERole.valueOf(ERole.ADMIN.name())).build()))
//                   .build();
//
//
//
//         user_repo.save(user_ent);
//        };
//    }
}
