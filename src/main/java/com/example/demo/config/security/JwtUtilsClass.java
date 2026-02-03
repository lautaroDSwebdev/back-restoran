package com.example.demo.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtilsClass {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.exp}")
    private String timeExpiration;


    public String generateUserAccesToken(String e) {
//        el builder genera el token
        return Jwts.builder()
                .setSubject(e)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    //    obtener fidma del metodo de acceso
    public Key getSignatureKey() {
        byte[] keybytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keybytes);
    }

    //    obtener un solo claim
//    retorna generico por que los claims tienen muchos caracteres distintos
    public <T> T getClaim(String token, Function<Claims, T> e) {
        Claims claim = extractClaims(token);
        return e.apply(claim);
    }

    //    Cuando queremos obtener un solo claim del body de json web token
    public <T> T getOneClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims extractClaims = extractClaims(token);
        return claimsTFunction.apply(extractClaims);
    }

    //    Aqui elegimos que claim queremos obtener en especifico
    public String getUsernameFromtToken(String token) {
        return getOneClaim(token, Claims::getSubject);
    }

    //obtener todos los claims
    public Claims extractClaims(String e) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(e)
                .getBody();
    }


    //    Validar token
    public boolean TokenValidate(String e) {
        try {
//            el parseBuilder lee el token
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(e)
                    .getBody();
            return true;
        } catch (Exception ex) {
            System.out.println("Token invalido: " + ex.getMessage());
            return false;

        }
    }


}
