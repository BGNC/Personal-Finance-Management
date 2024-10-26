package com.bgnc.personalfinancemanagement.jwt;

import com.bgnc.personalfinancemanagement.util.LocalDateToDateFormat;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTService {

    public static final String SECRET_KEY = "JfVoLB61pmyKbWswGsuxD6TMnPFZzsoOACmSd1mA5hM=";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean isTokenValid(String token) {

        Date expirationDate = getClaims(token).getExpiration();
        return new Date().before(expirationDate);
    }

    public<T> T exportToken(String token, Function<Claims,T>claimsFunction){

        Claims claims = getClaims(token);
        return claimsFunction.apply(claims);
    }

    public String getUsernameByToken(String token){
        return exportToken(token, Claims::getSubject);
    }

    public Date getDateByToken(String token){
        return exportToken(token, Claims::getIssuedAt);
    }

    private Key getKey(){
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }
}
