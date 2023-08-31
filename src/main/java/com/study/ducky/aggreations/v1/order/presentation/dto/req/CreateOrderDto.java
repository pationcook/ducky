package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

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
                .items(this.items.stream()
                        .map(CreateOrderItemDto::toCreate)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @NotNull
    @Size(min = 1)
    @Valid     // valid는 내 하위의 객체만 체크한다.
    private List<CreateOrderItemDto> items;
}
