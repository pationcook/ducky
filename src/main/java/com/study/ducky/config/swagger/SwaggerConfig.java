package com.study.ducky.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.study.ducky.config.swagger
 * fileName       : SwaggerConfig
 * author         : patio
 * date           : 2023-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-07-29           patio            최초 생성
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springOpenApi(){
        final var info = new Info()
                .title("Study Api")
                .description("Study Rest AP")
                .version("v1.0");
        return new OpenAPI().info(info);
    }
}
