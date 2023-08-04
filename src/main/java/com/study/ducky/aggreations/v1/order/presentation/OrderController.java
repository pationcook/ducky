package com.study.ducky.aggreations.v1.order.presentation;

import com.study.ducky.config.annotations.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<String> createOrders(@Valid  @RequestBody List<String> payload) {
        return payload;
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
