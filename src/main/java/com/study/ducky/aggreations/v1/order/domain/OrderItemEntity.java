package com.study.ducky.aggreations.v1.order.domain;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrderItem;
import com.study.ducky.aggreations.v1.order.enums.OrderItemStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.domain
 * fileName       : OrdeItemEntity
 * author         : patio
 * date           : 2023-08-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-23           patio            최초 생성
 */
@Table(catalog = "base", name ="orderItem")
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Getter
@EntityListeners(AuditingEntityListener.class)
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long itemId;
    private String itemName;

    @Enumerated(EnumType.STRING)
    private OrderItemStatusEnum status;
    private int price;
    private int qty;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private OrderAggregate order;

    public OrderItemEntity putOrder(OrderAggregate order){
        this.order = order;
        return this;
    }

    public OrderItemEntity patch(CreateOrderItem createOrderItem){
        this.itemId = createOrderItem.getItemId();
        this.itemName = createOrderItem.getItemName();
        this.price = createOrderItem.getPrice();
        this.qty = createOrderItem.getQty();
        return this;
    }
}
