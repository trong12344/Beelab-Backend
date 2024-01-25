package com.Beelab.Common.JWT;


import com.Beelab.Entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@AllArgsConstructor
public class JwtTokenProvider {

    private final JwtConfig jwtConfig;


    public String generateToken(User user){
        Date now = new Date();
        Date expiratedDay = new Date(now.getTime() + jwtConfig.getExpired());

        return Jwts.builder()
                .setSubject(Integer.toString(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expiratedDay)
                .signWith(SignatureAlgorithm.HS512
                        , jwtConfig.getSecret())
                .compact();
    }

    public int getUserIdFormJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtConfig.getSecret())
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

}
