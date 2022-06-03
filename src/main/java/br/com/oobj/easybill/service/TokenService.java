package br.com.oobj.easybill.service;

import br.com.oobj.easybill.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${easybill.jwt.expiration}")
    private String expirationn;

    @Value("${easybill.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authenticate) {

        User loggedUser = (User) authenticate.getPrincipal();
        Date date = new Date();
        Date expiration = new Date(date.getTime() + Long.parseLong(expirationn));

        return Jwts.builder()
                .setIssuer("Easybill")
                .setSubject(loggedUser.getId().toString())
                .setIssuedAt(date)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }

    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
