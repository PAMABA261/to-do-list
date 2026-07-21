package com.example.demo.config;

import java.util.Date;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import java.security.Key;

public class JWT {

    private final Key key = Keys.hmacShaKeyFor("BHGBTFBGYU/IY(Y/)(O/UY(YI/wyer7nw4yrcw7iy8rumworywoukref".getBytes());

    public String generateToken (String username) {
        Date fechaActual = new Date(System.currentTimeMillis());
        Date fechaCaducidad = new Date(System.currentTimeMillis() + 100000000);
        String token = Jwts.builder().setSubject(username).setIssuedAt(fechaActual).setExpiration(fechaCaducidad).signWith(key).compact();
        return token;
    }

    public String extractUsername (String token) {
        String parser = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
        return parser;
    }

    public boolean validateToken (String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
