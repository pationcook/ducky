package com.study.ducky.aggreations.v1.order.presentation.dto.res;

import com.study.ducky.aggreations.v1.order.enums.OrderItemStatusEnum;
import com.study.ducky.aggreations.v1.order.enums.OrderStatusEnum;
import com.study.ducky.config.mapstruct.base.BaseDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.res
 * fileName       : OrderDto
 * author         : patio
 * date           : 2023-09-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-16           patio            최초 생성
 */
@SuperBuilder
@Getter
public class OrderDto extends BaseDto {
    private Long id;
    private String orderNumber;
    private String orderName;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    private int price;
    private int deliveryFee;
    private String address;
    private long userId;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

    private List<OrderItemDto> orderItems;

}
