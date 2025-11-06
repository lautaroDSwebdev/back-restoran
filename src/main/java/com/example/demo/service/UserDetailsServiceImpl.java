//package com.example.demo.service;
//
//
//import com.example.demo.entity.UserEntity;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository user_repo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        UserEntity user_entity = user_repo.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("El usuario: " + username + "no fue enconctrado"));
//
//        Collection<? extends GrantedAuthority> authorities = user_entity
//                .getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName().name()))
//                .collect(Collectors.toSet());
//
//
//        return new User(user_entity.getUsername(),
//                user_entity.getPassword(),
//                true,
//                true,
//                true,
//                true, authorities);
//    }
//
//
//}