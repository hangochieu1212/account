package com.example.demo.jwt;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import javax.security.auth.message.AuthException;
import java.util.Date;

@Component
public class JwtProvider {
    private String jwtSecret = "hangochieu1212@gmail.com";
    private int jwtExpiration = 86400;

}
