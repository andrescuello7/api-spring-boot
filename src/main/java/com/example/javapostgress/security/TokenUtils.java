package com.example.javapostgress.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "$2a$10$FAfiFosMXKTZajyRgFtijebf/BG33vJ3ZdyQsKfDkncD2rGICXIRq";
    private final static Long ACCESS_TOKEN_EXPIRED = 2_592_000L;

    public static String createAccessToken(String username, String email) {
        long expiredTime = ACCESS_TOKEN_EXPIRED * 1_000;
        Date expiredDate = new Date(System.currentTimeMillis() + expiredTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expiredDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }
}
