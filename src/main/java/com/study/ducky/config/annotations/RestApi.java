package com.study.ducky.config.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName    : com.study.ducky.config.annotations
 * fileName       : RestApi
 * author         : patio
 * date           : 2023-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-07-29           patio            최초 생성
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping
public @interface RestApi {
    String name() default "";

    @AliasFor("path")
    String[] value() default {};

    @AliasFor("value")
    String[] path() default {};

    RequestMethod[] method() default {};

    String[] params() default {};


    String[] headers() default {};

    String[] consumes() default {};

    String[] produces() default {};
}
