package com.study.ducky.config.exception;

import com.study.ducky.config.exception.type.BaseExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * packageName    : com.study.ducky.config.exception
 * fileName       : ExceptionHadler
 * author         : patio
 * date           : 2023-09-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-23           patio            최초 생성
 */

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(DuckyException.class)
    public ResponseEntity<Error> exception(DuckyException de){
        return new ResponseEntity<>(Error.create(de.getExceptionType()), HttpStatus.BAD_REQUEST);
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Error {
        private int code;
        private int status;
        private String message;

        static Error create(BaseExceptionType exception){
            return new Error(exception.getErrorCode(),exception.getHttpStatus(),exception.getErrorMessage());
        }
    }
}
