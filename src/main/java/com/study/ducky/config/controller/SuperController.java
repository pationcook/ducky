package com.study.ducky.config.controller;

import com.study.ducky.config.mapstruct.base.BaseEntity;
import com.study.ducky.config.mapstruct.mapper.SupportEntityToDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.stream.Collectors;

/**
 * packageName    : com.study.ducky.config.controller
 * fileName       : SuperController
 * author         : patio
 * date           : 2023-09-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-27           patio            최초 생성
 */
public abstract class SuperController {
    public Page response(SupportEntityToDtoMapper mapper, Page<? extends BaseEntity> page, Pageable pageable){
        final var content = page.getContent();
        final var responses = content.stream()
                .map(c -> mapper.toDto(c))
                .collect(Collectors.toList());
        return new PageImpl<>(responses,pageable,page.getTotalElements());
    }
}
