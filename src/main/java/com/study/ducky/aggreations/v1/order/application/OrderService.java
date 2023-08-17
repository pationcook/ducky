package com.study.ducky.aggreations.v1.order.application;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.application
 * fileName       : OrderService
 * author         : patio
 * date           : 2023-08-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-12           patio            최초 생성
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    
    // setter 주입법  -  순환참조 걸릴 수 있다.
    private final OrderRepository orderRepository;

    public void create(CreateOrder createOrder){
        final var orderAggregate = OrderAggregate.builder()
                .build()
                .patch(createOrder)
                .create(orderRepository);

        orderRepository.save(orderAggregate);
    }
}
