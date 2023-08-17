package com.study.ducky.aggreations.v1.order.infrastructure.repository;

import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
