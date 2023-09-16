package com.study.ducky.aggreations.v1.order.domain;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.enums.OrderStatusEnum;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.OrderRepository;
import com.study.ducky.config.mapstruct.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class OrderAggregate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String orderName;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    private int price;
    private int deliveryFee;
    private String address;
    private long userId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<OrderItemEntity> orderItems;

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
        createOrder.getItems().forEach(item -> this.addItem(OrderItemEntity.builder()
                .build()
                .patch(item)));
        return this;
    }

    public OrderAggregate addItem(OrderItemEntity orderItem){
        Assert.notNull(orderItem, "OrderItem is null");
        if(this.getOrderItems() == null) {
            this.orderItems = new ArrayList<>();
        }
        orderItem.putOrder(this);
        this.orderItems.add(orderItem);
        return this;
    }
}
