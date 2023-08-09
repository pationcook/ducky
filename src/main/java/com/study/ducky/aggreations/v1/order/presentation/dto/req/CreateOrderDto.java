package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

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

    @Valid
    @NonNull
    private List<CreateOrderItemDto> items;
}
