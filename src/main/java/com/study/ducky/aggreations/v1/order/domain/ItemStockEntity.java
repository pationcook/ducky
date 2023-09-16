package com.study.ducky.aggreations.v1.order.domain;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItemStock;
import com.study.ducky.config.mapstruct.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.domain
 * fileName       : ItemEntity
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */
@Table(catalog = "base", name ="ItemStock")
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Getter
@EntityListeners(AuditingEntityListener.class)
public class ItemStockEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stock_qty;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="itemId")
    private ItemAggregate item;


    public ItemStockEntity putItem(ItemAggregate item){
        this.item = item;
        return this;
    }

    public ItemStockEntity patch(CreateItemStock createItemStock) {
        this.stock_qty = createItemStock.getStockQty();
        return this;
    }
}
