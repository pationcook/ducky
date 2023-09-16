package com.study.ducky.aggreations.v1.order.presentation.dto.res;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrderItem;
import com.study.ducky.aggreations.v1.order.enums.OrderItemStatusEnum;
import com.study.ducky.config.mapstruct.base.BaseDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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
@SuperBuilder
@Getter
public class OrderItemDto extends BaseDto {
    private Long id;
    private long itemId;
    private String itemName;
    private OrderItemStatusEnum status;
    private int price;
    private int qty;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    public CreateOrderItem toCreate(){
        return CreateOrderItem.builder()
                .itemId(this.itemId)
                .itemName(this.itemName)
                .price(this.price)
                .qty(this.qty)
                .build();
    }
}
