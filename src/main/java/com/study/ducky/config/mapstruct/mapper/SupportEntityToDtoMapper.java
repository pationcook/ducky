package com.study.ducky.config.mapstruct.mapper;

import com.study.ducky.config.mapstruct.base.BaseDto;
import com.study.ducky.config.mapstruct.base.BaseEntity;
import com.study.ducky.config.mapstruct.config.MapstructConfig;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * packageName    : com.study.ducky.config.mapstruct.mapper
 * fileName       : SupportEntityToDtoMapper
 * author         : patio
 * date           : 2023-09-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-16           patio            최초 생성
 */

//
@MapperConfig(
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SupportEntityToDtoMapper <E extends BaseEntity, D extends BaseDto> extends MapstructConfig {
//    E toEntity(D d);
    D toDto(E e);
}
