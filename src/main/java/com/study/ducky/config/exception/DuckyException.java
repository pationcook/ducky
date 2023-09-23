package com.study.ducky.config.exception;

import com.study.ducky.config.exception.type.BaseExceptionType;
import jakarta.validation.ValidationException;
import lombok.Getter;

/**
 * packageName    : com.study.ducky.config.exception
 * fileName       : DuckyException
 * author         : patio
 * date           : 2023-09-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-23           patio            최초 생성
 */
public class DuckyException extends RuntimeException {
    @Getter
    private BaseExceptionType exceptionType;

    public DuckyException(BaseExceptionType exceptionType){
        super(exceptionType.getErrorMessage());
        this.exceptionType = exceptionType;
    }
}
