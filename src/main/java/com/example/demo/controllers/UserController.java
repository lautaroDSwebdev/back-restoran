package com.example.demo.controllers;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.enums.ERole;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private PasswordEncoder passwEnc;

    @Autowired
    private UserRepository user_repo;

    @GetMapping("/ping")
    public String ping() {
        return "existe";
    }


    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO e) {

//        Acá estamos recibiendo un Set de strings con los roles y lo convertimos a un SET de la entidad RoleEntity
        Set<RoleEntity> roles = e.getRoles().stream()
                .map(rol -> RoleEntity.builder().name(ERole.valueOf(rol)).build())
                .collect(Collectors.toSet());

//        Acá armamos todo el usuario con la entidad UserDTO y conminamos lo que tramemos del SET de roles
        UsersEntity user_ent = UsersEntity.builder()
                .username(e.getUsername())
//                acá a la contraseña la envolvemos en el password encoder
                .password(passwEnc.encode(e.getPassword()))
                .email(e.getEmail())
                .roles(roles)
                .build();

        user_repo.save(user_ent);
        return ResponseEntity.ok(user_ent);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String id) {
        user_repo.deleteById(Long.parseLong(id));
        return "Se eliminó el usuario con id: " + id;
    }
}
