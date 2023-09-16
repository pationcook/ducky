package com.study.ducky.aggreations.v1.order.application;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import com.study.ducky.aggreations.v1.order.enums.OrderStatusEnum;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    @Transactional( readOnly = true)
    public OrderAggregate get(Long id){
        Optional<OrderAggregate> byId = orderRepository.findById(id);
        OrderAggregate orderAggregate = byId.orElseThrow();
        return orderAggregate;
    }


    /**
     * DB가 write 용이 존재할 때, 성능적으로 이점이 있다.
     * Transactional은 event 전파와 같이 전파되므로 상위 transaction이 존재하면 무시된다.
     * 무시되지 않을 방법은 propagation 을 이용하는 것이다.
     *
     * @param orderStatusEnum
     * @return
     */
    @Transactional(readOnly = true)
    public Page<OrderAggregate> listByStatus(OrderStatusEnum orderStatusEnum, Pageable pageable){
        Page<OrderAggregate> allByStatus = orderRepository.findAllByStatus(orderStatusEnum, pageable);
        return allByStatus;
    }

}
