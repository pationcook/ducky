package com.study.ducky.aggreations.v1.order.application.dto.req;

import com.study.ducky.aggreations.v1.order.enums.OrderItemStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.application.dto.req
 * fileName       : CreateOrderItem
 * author         : patio
 * date           : 2023-08-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-23           patio            최초 생성
 */
@Builder
@Getter
public class CreateOrderItem {
    private long itemId;
    private String itemName;

    private int price;
    private int qty;
}
