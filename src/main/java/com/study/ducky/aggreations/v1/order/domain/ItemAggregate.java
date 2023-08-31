package com.study.ducky.aggreations.v1.order.domain;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItem;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItemStock;
import com.study.ducky.aggreations.v1.order.enums.ItemStatusEnum;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.ItemRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.domain
 * fileName       : ItemAggregate
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */
@Table(catalog = "base", name = "item")
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class ItemAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private ItemStatusEnum status;
    private int price;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @LastModifiedDate
    private LocalDateTime deletedDate;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ItemStockEntity> items;

    public ItemAggregate create(ItemRepository itemRepository) {
        itemRepository.save(this);
        return this;
    }

    public static final List<ItemAggregate> creates(ItemRepository itemRepository, List<CreateItem> createItems) {
        Assert.notEmpty(createItems, "createItems is null");

        final var items = createItems.stream()
                .map(createItem -> ItemAggregate.builder()
                        .build()
                        .patch(createItem))
                .collect(Collectors.toList());
        itemRepository.saveAll(items);
        return items;
    }

    public ItemAggregate patch(CreateItem createItem) {
        this.itemName = StringUtils.defaultIfEmpty(createItem.getItemName(), this.itemName);
        this.price = createItem.getPrice();
        this.createdDate = LocalDateTime.now();
        createItem.getItems().forEach(item ->
        {
            this.addItem(ItemStockEntity.builder()
                    .build()
                    .patch(item));
        });
        return this;
    }

    public ItemAggregate addItem(ItemStockEntity itemStockEntity){
        Assert.notNull(itemStockEntity, "itemStock is null");
        if(this.getItems() == null) {
            this.items = new ArrayList<>();
        }
        itemStockEntity.putItem(this);
        this.items.add(itemStockEntity);
        return this;
    }
}
