//package com.example.demo.config.filters;
//
//
//import com.example.demo.config.security.JWTUtils;
//import com.example.demo.entity.UserEntity;
//import com.fasterxml.jackson.core.exc.StreamReadException;
//import com.fasterxml.jackson.databind.DatabindException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JWTAuthenFilter extends UsernamePasswordAuthenticationFilter {
//
//    private JWTUtils jwtUtils;
//
//    public JWTAuthenFilter(JWTUtils jwtUtils) {
//        this.jwtUtils = jwtUtils;
//    }
//
//    //    Esto es la autenticacion correcta de usuario
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        UserEntity dataUser = null;
//        String username = "";
//        String password = "";
//
//        try {
//            dataUser = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
//            username = dataUser.getUsername();
//            password = dataUser.getPassword();
//        } catch (StreamReadException e) {
//            throw new RuntimeException(e);
//        } catch (DatabindException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        UsernamePasswordAuthenticationToken authDataToken = new UsernamePasswordAuthenticationToken(username, password);
//        return getAuthenticationManager().authenticate(authDataToken);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//
//        User user = (User) authResult.getPrincipal();
//
//        String token = jwtUtils.generateAccesToken(user.getUsername());
//
//        response.addHeader("Authorization", token);
//        Map<String, Object> httpRes = new HashMap<>();
//        httpRes.put("token", token);
//        httpRes.put("Message", "Autenticacion exitosa");
//        httpRes.put("username", user.getUsername());
//
//        response.getWriter().write(new ObjectMapper().writeValueAsString(httpRes));
//        response.setStatus(HttpStatus.OK.value());
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.getWriter().flush();
//
//
//    }
//}