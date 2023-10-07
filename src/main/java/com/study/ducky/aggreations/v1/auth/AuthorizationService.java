package com.study.ducky.aggreations.v1.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * packageName    : com.study.ducky.aggregations.v1.auth
 * fileName       : AuthorizationService
 * author         : patio
 * date           : 2023-10-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-07        patio            최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorizationService {

    @Value("${jwt.access-token.key}")
    private String accessKey;

    public String createAccessToken(){

        final String issuer = "BASE";
        final String subject = "access";
        final String audience = "1";
        final Date expiredDt = Date.from(Instant.now().plus(Duration.ofDays(1L)));
        final Date notBeforeAt = Date.from(Instant.now());
        final Date issuedAt = Date.from(Instant.now());
        final String jwtId = UUID.randomUUID().toString();
        final SecretKey signatureKey = Keys.hmacShaKeyFor(
                Base64.getEncoder()
                        .encodeToString(accessKey.getBytes())
                        .getBytes()
        );




        final String accessToken = Jwts.builder()
                .issuer(issuer)
                .subject(subject)
                .expiration(expiredDt)
                .id(jwtId)
                .issuedAt(issuedAt)
                .notBefore(notBeforeAt)
                .signWith(signatureKey)
                .audience()
                .single(audience)
                .compact();
        return accessToken;
    }
}
