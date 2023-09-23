package com.study.ducky.aggreations.v1.order.presentation;

import com.study.ducky.aggreations.v1.order.application.OrderService;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.domain.OrderAggregate;
import com.study.ducky.aggreations.v1.order.domain.OrderItemEntity;
import com.study.ducky.aggreations.v1.order.enums.OrderStatusEnum;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.CreateOrdersDto;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.OrderSearchConditions;
import com.study.ducky.aggreations.v1.order.presentation.dto.res.OrderDto;
import com.study.ducky.config.annotations.*;
import com.study.ducky.config.mapstruct.mapper.OrderEntityDtoMapper;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation
 * fileName       : OrderController
 * author         : patio
 * date           : 2023-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-07-29           patio            최초 생성
 */
@RestApi("/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {


    private final OrderService orderService;

    private final OrderEntityDtoMapper orderEntityDtoMapper;

    @Get("/conditions/{startDate}/{endDate}/{price}")
    public Page<OrderDto> getOrders(
            @PathVariable String startDate,
            @PathVariable String endDate,
            @PathVariable(required = false) @PositiveOrZero int price,
            @PageableDefault(size= 10, sort="id", direction=Sort.Direction.DESC) Pageable pageable
    )
    throws ValidationException {


        OrderSearchConditions orderSearchConditions = OrderSearchConditions.builder()
                .price(price)
                .build();
        // validation
        orderSearchConditions.dateInitValidation(startDate, endDate);
        orderSearchConditions.dateValidation();
        orderSearchConditions.priceValidation();


        Page<OrderAggregate> pageOrders = orderService
                .listBySearchCondition(orderSearchConditions, pageable);


        List<OrderAggregate> orders = pageOrders.getContent();
        List<OrderDto> orderDtos  = orders.stream()
                .map(order -> orderEntityDtoMapper.toDto(order))
                .collect(Collectors.toList());
        return new PageImpl<>(orderDtos, pageable, pageOrders.getTotalElements());
    }

    @Get("/status/{status}")
    public Page<OrderDto> getOrders(
            @PathVariable OrderStatusEnum status,
            @PageableDefault(size= 10, sort="id", direction=Sort.Direction.DESC) Pageable pageable
            ){
        Page<OrderAggregate> pageOrders = orderService.listByStatus(status ,pageable);
        List<OrderAggregate> orders = pageOrders.getContent();
        // jpa 는 null 이 존재하지 않는다. => 빈리스트
        List<OrderDto> orderDtos = orders.stream()
                .map(order -> orderEntityDtoMapper.toDto(order))
                .collect(Collectors.toList());
        return new PageImpl<>(orderDtos, pageable, pageOrders.getTotalElements());
    }



//    @Post
//    public Long createOrders(
//            // 해당 객체에 대한 validation 검사를 하라고 명시하는 것. @valid
//            @Valid
//            @RequestBody CreateOrderDto payload) {
//        orderService.create(payload.toCreate());
//        return 0L;
//    }
    @Post
    public ResponseEntity createOrders(
            // 해당 객체에 대한 validation 검사를 하라고 명시하는 것. @valid
            @Valid
            @RequestBody CreateOrdersDto payload) throws Exception{
        log.info(payload.toString());
        List<CreateOrder> list = payload.toCreate();
        int duplicateCount = 0;
        try {
//            duplicateCount = orderService.duplicateByUserId(list);
//            if(duplicateCount > 0) {
//                throw new Exception();
//            }
            List<Long> result = orderService.creates(list);
            return ResponseEntity.ok(result);
        } catch ( Exception e) {
//            return ResponseEntity.internalServerError().body(Result.builder().message("중복 건수 :" + duplicateCount));
            throw new Exception();

        }
    }

    @Get("/{id}")
    public OrderDto getOrder(@PathVariable long id) {
        OrderAggregate orderAggregate = getOrderAggregate(id);

        List<OrderItemEntity> items = orderAggregate.getOrderItems();


        OrderDto orderDto = orderEntityDtoMapper.toDto(orderAggregate);
        // 아이템즈를 재조회하는 이유는 이 지랄을 해야 조회가 됨.
        // => 이유: 객체의 리스트는 초기화 널로 되있고 해당 객체의 리스트는 재정의가 안되있으므로 직접 뺀다음 셋해주는 작업이 들어가야함.
        // => 개선: 위처럼 mapstruct를 만들어서 사용하는 방법이 추천됨.
//        final List<OrderItemDto> itemDtos = items.stream().map(item ->
//                OrderItemDto.builder()
//                        .id(item.getId())
//                        .itemId(item.getItemId())
//                        .itemName(item.getItemName())
//                        .status(item.getStatus())
//                        .price(item.getPrice())
//                        .qty(item.getQty())
//                        .createdDate(item.getCreatedDate())
//                        .updatedDate(item.getUpdatedDate())
//                        .build())
//                .collect(Collectors.toList());
//
//        return OrderDto.builder()
//                .id(orderAggregate.getId())
//                .orderNumber(orderAggregate.getOrderNumber())
//                .orderName(orderAggregate.getOrderNumber())
//                .status(orderAggregate.getStatus())
//                .price(orderAggregate.getPrice())
//                .deliveryFee(orderAggregate.getDeliveryFee())
//                .address(orderAggregate.getAddress())
//                .userId(orderAggregate.getUserId())
//                .updatedDate(orderAggregate.getUpdatedDate())
//                .createdDate(orderAggregate.getCreatedDate())
//                .orderItemDto(itemDtos)
//                .build();
        return orderDto;
    }




    private OrderAggregate getOrderAggregate(long id) {
        return orderService.get(id);
    }

    @Put
    public void putOrders(@Valid  @RequestBody List<String> payload) {
        System.out.println(payload);
    }

    @Delete
    public void deleteOrders(@Valid  @RequestBody List<String> payload) {
        System.out.println(payload);
    }
}
