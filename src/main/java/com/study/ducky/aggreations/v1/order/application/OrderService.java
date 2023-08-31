package com.study.ducky.aggreations.v1.order.application;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
@Slf4j
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

    public int duplicateByUserId(List<CreateOrder> createOrders){
        Example<List<CreateOrder>> example = (Example<List<CreateOrder>>) createOrders;
//        return orderRepository.find;
        return 0;
    }

    public List<Long> creates(List<CreateOrder> createOrders) {
        List<OrderAggregate> orderAggregates = createOrders.stream()
                .map(createOrder -> OrderAggregate.builder()
                        .build()
                        .patch(createOrder))
                .collect(Collectors.toList());
            orderRepository.saveAll(orderAggregates);
            return orderAggregates.stream()
                    .map(OrderAggregate::getId)
                    .toList();
    }
}
