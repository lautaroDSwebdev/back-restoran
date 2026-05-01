package com.example.demo.service.Impl;

import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository user_repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersEntity usuario = user_repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));


// Convertimos los roles (Enum o String) a SimpleGrantedAuthority
        List<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());


        return new CustomUserDetails(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEmail(), // Aquí pasas la info extra
                authorities
        );
    }


////    //    El usuario que va a usar autenticado, lo tiene que buscar en la base de datos, si el usuario no existe pues no va a otorgar el acceso
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
//////        buscamos el usuario desde su nombre y si no existe, retornar esa excepcion
////        UsersEntity user_entity = user_repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("usuario " + username + " no existe"));
////
////// Estos son los permisos del usuario
////        Collection<? extends GrantedAuthority> authorities = user_entity.getRoles()
////                .stream()
////                .map(e -> new SimpleGrantedAuthority("ROLE_".concat(e.getName().name())))
////                .collect(Collectors.toSet());
////
////        return new User(user_entity.getUsername(), user_entity.getPassword(), true, true, true, true, authorities);
//    }
}
