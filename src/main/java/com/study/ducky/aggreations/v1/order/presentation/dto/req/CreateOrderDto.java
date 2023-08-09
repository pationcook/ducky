package com.study.ducky.aggreations.v1.order.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto
 * fileName       : CreateOrderDto
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
public class CreateOrderDto {
    private int price;
    private int deliveryFee;
    private int isTaxation;
    @NonNull
    private String address;
}
