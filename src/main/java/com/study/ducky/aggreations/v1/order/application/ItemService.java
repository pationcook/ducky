package com.study.ducky.aggreations.v1.order.application;

import com.study.ducky.aggreations.v1.order.application.dto.req.CreateItem;
import com.study.ducky.aggreations.v1.order.domain.ItemAggregate;
import com.study.ducky.aggreations.v1.order.infrastructure.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.application
 * fileName       : ItemService
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public List<Long> creates(List<CreateItem> createItems) {
        final var items = ItemAggregate.creates(itemRepository, createItems);

        return items.stream()
                .map(ItemAggregate::getId)
                .toList();
    }
}
