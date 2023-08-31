package com.study.ducky.aggreations.v1.order.enums;

import lombok.Getter;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.enums
 * fileName       : OrderStatusEnum
 * author         : patio
 * date           : 2023-08-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-23           patio            최초 생성
 */
@Getter
public enum OrderStatusEnum {
    ORDER("주문"),
    CANCELED("취소");

    private String status;

    OrderStatusEnum(String status){
        this.status = status;
    }
}
