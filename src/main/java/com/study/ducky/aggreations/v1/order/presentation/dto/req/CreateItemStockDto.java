package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItemStock;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.req
 * fileName       : CreateItemStockDto
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
public class CreateItemStockDto {
    @PositiveOrZero
    private int stockQty;

    public CreateItemStock toCreate(){
        return CreateItemStock.builder()
                .stockQty(this.stockQty)
                .build();
    }
}
