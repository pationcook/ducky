package com.study.ducky.aggreations.v1.order.application.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.application.dto.req
 * fileName       : CreateItemStock
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
public class CreateItemStock {
    private int stockQty;
}
