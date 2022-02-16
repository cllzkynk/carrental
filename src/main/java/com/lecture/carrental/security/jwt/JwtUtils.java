package com.lecture.carrental.security.jwt;


import com.lecture.carrental.security.service.UserDetailsImpl;
import com.lecture.carrental.security.service.UserDetailsServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;


public class JwtUtils {


    @Value("${backendapi.app.jwtSecret}")
    private String jwtSecret;


    @Value("${backendapi.app.jwtExpirationMs}")
    private long jwtExpirationMs;



    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject("" + (userDetails.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}