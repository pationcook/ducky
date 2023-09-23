package com.study.ducky.config.exception.type;

import lombok.Getter;

/**
 * packageName    : com.study.ducky.config.exception.type
 * fileName       : DuckyExceptionType
 * author         : patio
 * date           : 2023-09-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-23           patio            최초 생성
 */
@Getter
public enum DuckyExceptionType implements BaseExceptionType {

    ORDER_DATE_VALIDATION_ERROR(5000,400,"꺼졍"),
    ORDER_PRICE_VALIDATION_ERROR(5000,400,"배달비 안나온다 ㅡ,ㅡ");



    private int errorCode;
    private int httpStatus;
    private String errorMessage;



    DuckyExceptionType(int errorCode, int httpStatus, String errorMessage){
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
