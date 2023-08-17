package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String orderNumber;

    @NotNull
    private String orderName;
    private int price;
    private int deliveryFee;

    @NotNull
    private String address;
    private long userId;

    public CreateOrder toCreate() {
        return CreateOrder.builder()
                .orderName(this.orderName)
                .orderNumber(this.orderNumber)
                .price(this.price)
                .deliveryFee(this.deliveryFee)
                .address(this.address)
                .userId(this.userId)
                .build();
    }

//    @NotNull
//    @Valid
//    private List<CreateOrderItemDto> items;
}
