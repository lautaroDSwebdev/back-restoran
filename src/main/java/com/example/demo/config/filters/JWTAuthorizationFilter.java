package com.example.demo.config.filters;

import com.example.demo.config.security.JwtUtilsClass;
import com.example.demo.service.Impl.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtilsClass jwt_ut;

    @Autowired
    private UserDetailsServiceImpl userdet_imp;

    //    Segunda capa de validacion para el login, filtro para validar el token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");
//        Si el token es verdadero y empieza con Bearer
        if (token != null && token.startsWith("Bearer ")) {
//           obtener la respuesta deel token desde el caracter 7 en adelante, quitando la palabra Beader y el espacio
            String tokenHeader = token.substring(7);
            if (jwt_ut.TokenValidate(tokenHeader)) {
//Si el token es correcto, buscamos el usuario pertenetiente por el token
                String username = jwt_ut.getUsernameFromtToken(token);
//                y cargamos el usuario entero mediante el nombre de usuario
                UserDetails userDet = userdet_imp.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken userPassAuthToken =
                        new UsernamePasswordAuthenticationToken(username, null, userDet.getAuthorities());
//obtenemos la primera autenticacion del context holder envolvente de la aplicacion
                SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);
            }
        }
//        Continua con el filtro de validacion en caso de que la autenticacion haya fallado
        filterChain.doFilter(request, response);

    }


}
