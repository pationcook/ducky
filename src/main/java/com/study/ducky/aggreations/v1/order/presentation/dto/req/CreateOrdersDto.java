package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
public class CreateOrdersDto {
    @NotNull
    @Valid
    private List<CreateOrderDto> orders;

    @JsonCreator
    public CreateOrdersDto(@JsonProperty("orders") List<CreateOrderDto> orders) {
        this.orders = orders;
    }

    public List<CreateOrder> toCreate() {
        List<CreateOrder> createOrders = orders.stream()
                .map(createOrderDto -> {
                    CreateOrder createOrder = createOrderDto.toCreate();
                    return createOrder;
                })
                .collect(Collectors.toList());
        return createOrders;
    }
}
