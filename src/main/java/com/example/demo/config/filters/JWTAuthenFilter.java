package com.example.demo.config.filters;

import com.example.demo.config.security.JwtUtilsClass;
import com.example.demo.entity.UsersEntity;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenFilter extends UsernamePasswordAuthenticationFilter {


    private JwtUtilsClass jwt_utils;

    public JWTAuthenFilter(JwtUtilsClass jwt_utils) {
        this.jwt_utils = jwt_utils;
    }

    //capa de autenticacion del usuario
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        UsersEntity user_entity = null;
        String username = "";
        String password = "";

        try {
            user_entity = new ObjectMapper().readValue(request.getInputStream(), UsersEntity.class);
            username = user_entity.getUsername();
            password = user_entity.getPassword();


        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(authToken);


    }

    //capa de respuesta exitosa de la autenticacion del usuario y generador del token
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();
//        acá le damos a jwt dedde el generador de token de acceso el username del usuario ya autenticado
        String token = jwt_utils.generateUserAccesToken(user.getUsername());
        response.addHeader("Authorization", token);

//        Acá a la trespuesta la convertimos en un json y es lo que nos va a responder el login
        Map<String, Object> httpResp = new HashMap<>();
    httpResp.put("token", token);
    httpResp.put("message", "Authentication succesful");
    httpResp.put("username",  user.getUsername());
//    httpResp.put("password ",  user.getPassword());

        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResp));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();
    }

}
