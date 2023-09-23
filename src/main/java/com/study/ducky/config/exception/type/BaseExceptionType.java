package com.study.ducky.config.exception.type;

/**
 * packageName    : com.study.ducky.config.exception.type
 * fileName       : BaseExceptionType
 * author         : patio
 * date           : 2023-09-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-23           patio            최초 생성
 */
public interface BaseExceptionType {
    int getErrorCode();
    int getHttpStatus();
    String getErrorMessage();
}
