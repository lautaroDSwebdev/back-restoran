//package com.example.demo.controllers;
//
//import com.example.demo.dto.CreateUserDTO;
//import com.example.demo.entity.ERole;
//import com.example.demo.entity.RoleEntity;
//import com.example.demo.entity.UserEntity;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.service.inter.IUsersService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private PasswordEncoder pass_encode;
//
//    @Autowired
//    private UserRepository user_repo;
//
//    @Autowired
//    private IUsersService user_serv;
//
//    @GetMapping("/all-users")
//    public  ResponseEntity<Page<UserEntity>> GetUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ){
//        Page<UserEntity> users_get = user_serv.GetAllUsers(page, size);
//
//        return ResponseEntity.ok(users_get);
//    }
//
//    @PostMapping("/createUser")
//    public ResponseEntity<?> PostUser(@Valid @RequestBody CreateUserDTO createUserDto){
//
//        Set<RoleEntity> roles = createUserDto.getRoles().stream()
//                .map(role -> RoleEntity.builder().roleName(ERole.valueOf(role))
//
//                        .build()).collect(Collectors.toSet());
//
//        UserEntity entity_user = UserEntity.builder()
//                .username(createUserDto.getUsername())
////y de esta manera hacemos que lo tome la contraseña de usuario
//                .password(pass_encode.encode(createUserDto.getPassword()))
//                .email(createUserDto.getEmail())
//                .roles(roles)
//                .build();
//
//        user_repo.save(entity_user);
//        return ResponseEntity.ok(entity_user);
//    }
//
//    @DeleteMapping("/delete-user/{id}")
//    public String DeleteUser(@PathVariable Long id){
//        user_repo.deleteById(id);
//        return "Usuario eliminado";
//    }
//}
