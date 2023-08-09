package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.req
 * fileName       : CreateOrderItemDto
 * author         : patio
 * date           : 2023-08-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-05           patio            최초 생성
 */
@Builder
@Getter
public class CreateOrderItemDto {
    private long itemId;

    @NonNull
    private String itemName;
    private int price;
}
