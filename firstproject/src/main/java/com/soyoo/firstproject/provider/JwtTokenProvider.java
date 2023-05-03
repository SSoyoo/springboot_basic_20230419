package com.soyoo.firstproject.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    // jwt 생성 혹은 검증에 사용 될 시크릿 키
    // 시크릿 키 같은 데이터는 보안에 유의해야하기 때문에
    // application.poperties 또는 환경변수로 등록해서 사용

    @Value("${jwt.secret-key}") // properties에 있는 걸 가져 오는 것
    private String SECRET_KEY;

    // JWT 생성 메서드
    public String create(String subject) {
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        String jwt = 
            Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, subject)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .compact();
        return jwt;
    }

    //JWT검증
    public String validate(String jwt){
        Claims claims = 
            (Claims) Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parse(jwt)
            .getBody();

                return claims.getSubject();
    }


}
