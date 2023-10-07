package com.study.ducky.aggreations.v1.order.infrastructure.repository.dto.req;

import com.study.ducky.config.annotations.Get;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.infrastructure.repository.dto.req
 * fileName       : OrderCondition
 * author         : patio
 * date           : 2023-09-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-27           patio            최초 생성
 */
@Getter
@Builder
public class OrderCondition {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int price;
    private Pageable pageable;
}
