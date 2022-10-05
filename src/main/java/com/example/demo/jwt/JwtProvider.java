package com.example.demo.jwt;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JwtProvider {
    private String jwtSecret = "hangochieu1212@gmail.com";
    private int jwtExpiration = 86400;

    //Create Token
    public String generateJwtToken(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.ES512, jwtSecret)
                .compact();
    }

    //Validate Token
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            throw new RuntimeException("Token không hợp lệ.", e);
        }
    }

    //Verify Token
    public String getUserNameFromJwtToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody().getSubject();
        } catch (Exception e) {
            if(e instanceof ExpiredJwtException) {
                throw new RuntimeException("Token đã hết hạn.");
            } else {
                throw new RuntimeException("Có lỗi xảy ra.");
            }

        }
    }

}
