package com.study.ducky.aggreations.v1.order.infrastructure.repository.dto.res;

import com.study.ducky.aggreations.v1.order.enums.OrderStatusEnum;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.infrastructure.repository.dto.res
 * fileName       : OrderInfoProjection
 * author         : patio
 * date           : 2023-09-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-27           patio            최초 생성
 */
@Getter
@Builder
public class OrderInfoProjection {

    private String orderNumber;
    private OrderStatusEnum status;
    private int price;
    private LocalDateTime createdDate;
}
