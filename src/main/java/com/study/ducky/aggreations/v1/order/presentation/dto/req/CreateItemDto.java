package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItem;
import com.study.ducky.aggreations.v1.order.enums.ItemStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.req
 * fileName       : CreateItemDto
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */

@Builder
@Getter
public class CreateItemDto {
    @NonNull
    String itemName;

    @Enumerated(EnumType.STRING)
    ItemStatusEnum status;
    @PositiveOrZero
    int price;
    @NotNull
    @Size(min = 1)
    @Valid     // valid 는 내 하위의 객체만 체크한다.
    private List<CreateItemStockDto> items;


    public CreateItem toCreate() {
        return CreateItem.builder()
                .itemName(this.itemName)
                .status(this.status)
                .price(this.price)
                .items(this.items.stream()
                        .map(CreateItemStockDto::toCreate)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
