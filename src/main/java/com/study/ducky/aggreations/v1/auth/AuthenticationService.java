package com.study.ducky.aggreations.v1.auth;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * packageName    : com.study.ducky.aggreations.v1.auth
 * fileName       : AuthenticationService
 * author         : patio
 * date           : 2023-10-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-07           patio            최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    @Value("${jwt.access-token.key}")
    private String accessKey;

    public boolean doAuthentication(String accessToken){

        final SecretKey signatureKey = Keys.hmacShaKeyFor(
                Base64.getEncoder()
                        .encodeToString(accessKey.getBytes())
                        .getBytes()
        );

        // 현재시간 기준으로 키 발급 하는 형식
        // final SecretKey signatureKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        try {
            Jwts.parser()
                    .setSigningKey(signatureKey)
                    .build()
                    .parseSignedClaims(accessToken);

        } catch (JwtException | IllegalArgumentException ie) {
            return false;
        }
        return true;
    }
}
