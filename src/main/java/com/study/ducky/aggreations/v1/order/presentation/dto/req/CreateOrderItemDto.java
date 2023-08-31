package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrderItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
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

    @PositiveOrZero
    private long itemId;

    @NonNull
    private String itemName;

    @PositiveOrZero
    private int price;

    @PositiveOrZero
    private int qty;

    public CreateOrderItem toCreate(){
        return CreateOrderItem.builder()
                .itemId(this.itemId)
                .itemName(this.itemName)
                .price(this.price)
                .qty(this.qty)
                .build();
    }
}
