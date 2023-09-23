package com.study.ducky.aggreations.v1.order.infrastructure.repository;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import com.study.ducky.aggreations.v1.order.enums.OrderStatusEnum;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.OrderSearchConditions;
import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.infrastructure.repository
 * fileName       : OrderRepostory
 * author         : patio
 * date           : 2023-08-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-12           patio            최초 생성
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderAggregate, Long> {
    
    // 행님 이러케쓰고싶슴니다...ㅠㅠ
//    Page<OrderAggregate> findAllBySearchConditions(OrderSearchConditions orderSearchConditions, Pageable pageable);

    Page<OrderAggregate> findAllByCreatedDateBetweenAndPriceIsGreaterThan(LocalDateTime startDate, LocalDateTime endDate, int price, Pageable pageable);

//    List<OrderAggregate> findAllByUserId(List<Long> userIds);

    Page<OrderAggregate> findAllByStatus(OrderStatusEnum orderStatusEnum, Pageable pageable);
}
