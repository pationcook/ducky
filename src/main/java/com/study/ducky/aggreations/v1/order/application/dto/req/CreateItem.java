package com.study.ducky.aggreations.v1.order.application.dto.req;

import com.study.ducky.aggreations.v1.order.enums.ItemStatusEnum;
import com.study.ducky.config.annotations.Get;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.application.dto.req
 * fileName       : CreateItem
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
@ToString
public class CreateItem {
    String itemName;

    @Enumerated(EnumType.STRING)
    ItemStatusEnum status;

    int price;

    private List<CreateItemStock> items;
}
