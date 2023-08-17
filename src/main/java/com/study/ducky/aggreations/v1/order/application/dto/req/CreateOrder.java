package com.study.ducky.aggreations.v1.order.application.dto.req;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.application.dto.req
 * fileName       : CreateOrder
 * author         : patio
 * date           : 2023-08-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-12           patio            최초 생성
 */
@Builder
@Getter
public class CreateOrder {
    private String orderNumber;
    private String orderName;
    private String status;
    private int price;
    private int deliveryFee;
    private String address;
    private Long userId;
}
