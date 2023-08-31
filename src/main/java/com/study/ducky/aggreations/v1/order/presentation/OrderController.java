package com.study.ducky.aggreations.v1.order.presentation;

import com.study.ducky.aggreations.v1.order.application.OrderService;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateOrder;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.CreateOrderDto;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.CreateOrdersDto;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.Result;
import com.study.ducky.config.annotations.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;



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

    @Get
    public List<String> getOrders(){
        return List.of("A","B","C");
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
            return ResponseEntity.internalServerError().body(Result.builder().message("중복 건수 :" + duplicateCount));
        }
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
