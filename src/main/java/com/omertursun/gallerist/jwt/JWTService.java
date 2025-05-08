package com.omertursun.gallerist.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTService {

    private static final String SECRET_KEY = "zJExoSpGS5JeSaf58FdwfMwn55RHi2_fXgDcZyC2UYw";

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 2))
                .signWith(null, SignatureAlgorithm.HS256).compact();

    }

    public <T> T exportToken(String token, Function<Claims,T> claimsFunction) {

        Claims claims = getClaims(token);
        return claimsFunction.apply(claims);

    }

    public Claims getClaims(String token) {
         return  Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token).getBody();
    }

    public Key getKey(){
        byte[] bytes = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String getUsernameFromToken(String token) {
        return exportToken(token, Claims::getSubject);
    }
    public boolean validateToken(String token) {
        Date expireDate = exportToken(token, Claims::getExpiration);
        return new Date().before(expireDate);
    }

}
