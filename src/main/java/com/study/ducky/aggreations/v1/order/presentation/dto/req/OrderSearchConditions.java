package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.config.exception.DuckyException;
import com.study.ducky.config.exception.type.DuckyExceptionType;
import jakarta.validation.ValidationException;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.req
 * fileName       : OrderConditions
 * author         : patio
 * date           : 2023-09-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-23           patio            최초 생성
 */



@Slf4j
@Builder
@Getter
public class OrderSearchConditions {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int price;


    public void dateInitValidation(String startDt, String endDt){
        try {
            LocalDate startDate = LocalDate.parse(startDt);
            LocalDate endDate = LocalDate.parse(endDt);
            this.startDate = LocalDateTime.of(startDate.minusDays(1), LocalTime.of(0,0,0));
            this.endDate = LocalDateTime.of(endDate,LocalTime.of(23,59,59));
        } catch (DateTimeParseException dpe) {
            log.warn(dpe.getMessage());
            throw new DuckyException(DuckyExceptionType.ORDER_DATE_VALIDATION_ERROR);
        }
    }


    /**
     * 날짜 함수 벨리데이션
     */
    public void dateValidation(){
        if(this.endDate.isBefore(this.startDate)){
            throw new DuckyException(DuckyExceptionType.ORDER_DATE_VALIDATION_ERROR);
        }
    }

    /**
     * 가격 벨리데이션
     */
    public void priceValidation(){
        if(this.price < 1000){
            throw new DuckyException(DuckyExceptionType.ORDER_PRICE_VALIDATION_ERROR);
        }
    }
}
