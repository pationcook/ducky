package com.study.ducky.aggreations.v1.order.enums;

import lombok.Getter;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.enums
 * fileName       : OrderItemStatusEnum
 * author         : patio
 * date           : 2023-08-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-23           patio            최초 생성
 */
@Getter
public enum OrderItemStatusEnum {
    ORDER("주문"),
    CANCELED("취소"),
    PARTIAL_CANCELED("부분취소");

    private String status;

    OrderItemStatusEnum(String status){
        this.status = status;
    }
}
