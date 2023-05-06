package com.api.jwtauth.security;

import com.api.jwtauth.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JWTService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.signKey}")
    private String signKey;

    private Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser().setSigningKey(signKey).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token){
        try{
            Claims claims = getClaims(token);
            Date expirationDate = claims.getExpiration();
            LocalDateTime localDateTime = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(localDateTime);
        }
        catch (Exception ex){
            return false;
        }
    }

    public String getLogin(String token) throws ExpiredJwtException{
        return (String) getClaims(token).getSubject();
    }

    public String generateToken(User user){
        long expirationString = Long.valueOf(expiration); // Is in minutes
        LocalDateTime expirationDateTime = LocalDateTime.now().plusMinutes(expirationString);
        Instant instant = expirationDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        // HashMap<String, Object> claims = new HashMap<>();
        // claims.put("roles", "ADMIN");

        return Jwts
                .builder()
                .setSubject(user.getLogin())
                .setExpiration(date)
                // .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, signKey)
                .compact();
    }
}
