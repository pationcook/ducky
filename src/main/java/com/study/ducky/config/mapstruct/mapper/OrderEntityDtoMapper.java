package com.study.ducky.config.mapstruct.mapper;

import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import com.study.ducky.aggreations.v1.order.presentation.dto.res.OrderDto;
import com.study.ducky.config.mapstruct.base.BaseEntity;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

/**
 * packageName    : com.study.ducky.config.mapstruct.mapper
 * fileName       : OrderEntityDtoMapper
 * author         : patio
 * date           : 2023-09-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-16           patio            최초 생성
 */
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderEntityDtoMapper extends SupportEntityToDtoMapper<OrderAggregate, OrderDto> {

    // 빌드시 조건을 추가해주기 위한 어노테이션
    @Condition
    default boolean isLazyLoaded(List<OrderAggregate> entities) {
        return isLoaded(entities);
    }
}
