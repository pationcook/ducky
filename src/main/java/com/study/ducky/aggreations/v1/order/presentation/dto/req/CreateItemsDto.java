package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.req
 * fileName       : CreateItemsDto
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
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemsDto {
    private List<CreateItemDto> createItems;

    public List<CreateItem> toCreateItem(){
        return this.createItems.stream()
                .map(CreateItemDto::toCreate)
                .collect(Collectors.toList());
    }
}
