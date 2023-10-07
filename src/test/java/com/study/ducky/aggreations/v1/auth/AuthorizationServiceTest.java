package com.study.ducky.aggreations.v1.auth;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.study.ducky.aggreations.v1.auth
 * fileName       : AuthorizationServiceTest
 * author         : patio
 * date           : 2023-10-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-07           patio            최초 생성
 */

@DisplayName("[서비스] Authorization(인가)")
@ExtendWith(MockitoExtension.class)
@Slf4j
class AuthorizationServiceTest {

    @InjectMocks
    private AuthorizationService authorizationService;

    @BeforeEach
    void init(){
        ReflectionTestUtils.setField(authorizationService, "accessKey" , "spring-boot-base-study-auth");
    }
    @Test
    void 토큰_생성(){
        // 기븐은 사전 데이터
        // 기본 설정
        // given

        // 실행
        // when
        final var accessToken = authorizationService.createAccessToken();
        assertAll(
                ()-> assertNotNull(accessToken)
        );
        // 결과
        // then
        log.info(accessToken);


    }

    @Test
    void 토큰_인증(){

    }
}