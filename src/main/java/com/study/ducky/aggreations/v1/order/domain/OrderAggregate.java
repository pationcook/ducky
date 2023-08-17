package com.study.ducky.aggreations.v1.order.domain;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.OrderRepository;
import com.study.ducky.config.annotations.Get;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.domain
 * fileName       : OrderAggregate
 * author         : patio
 * date           : 2023-08-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-12           patio            최초 생성
 */
@Table(catalog = "base", name = "order")
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class OrderAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String orderName;
    private String status;
    private int price;
    private int deliveryFee;
    private String address;
    private long userId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public OrderAggregate create(OrderRepository orderRepository) {
        orderRepository.save(this);
        return this;
    }

    public OrderAggregate patch(CreateOrder createOrder) {
        this.orderNumber = StringUtils.defaultIfEmpty(createOrder.getOrderNumber(), this.orderNumber);
        this.orderName = StringUtils.defaultIfEmpty(createOrder.getOrderNumber(), this.orderName);
        this.price = createOrder.getPrice();
        this.deliveryFee = createOrder.getDeliveryFee();
        this.address = StringUtils.defaultIfEmpty(createOrder.getOrderNumber(), this.address);
        this.userId = createOrder.getUserId();
        this.createdDate = LocalDateTime.now();
        return this;
    }
}
