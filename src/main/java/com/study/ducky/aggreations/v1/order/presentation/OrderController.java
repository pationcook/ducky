package com.study.ducky.aggreations.v1.order.presentation;

import com.study.ducky.aggreations.v1.order.presentation.dto.req.CreateOrderDto;
import com.study.ducky.config.annotations.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

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
public class OrderController {

    @Get
    public List<String> getOrders(){
        return List.of("A","B","C");
    }


    @Post
    public Long createOrders(
            // 해당 객체에 대한 validation 검사를 하라고 명시하는 것. @valid
            @Valid
            @RequestBody CreateOrderDto payload) {
        return 0L;
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
