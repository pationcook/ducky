package com.study.ducky.aggreations.v1.order.presentation;

import com.study.ducky.aggreations.v1.order.application.ItemService;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItem;
import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItemStock;
import com.study.ducky.aggreations.v1.order.presentation.dto.req.CreateItemsDto;
import com.study.ducky.config.annotations.Post;
import com.study.ducky.config.annotations.RestApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation
 * fileName       : ItemController
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */
@RestApi("/v1/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;
    @Post
    public List<Long> createItems(
            // 해당 객체에 대한 validation 검사를 하라고 명시하는 것. @valid
            @Valid
            @RequestBody CreateItemsDto payload) {
        final var create = payload.toCreateItem();
        final var ids = itemService.creates(create);
        return ids;
    }
}
