package com.study.ducky.config.mapstruct.config;

import com.study.ducky.config.mapstruct.base.BaseEntity;
import org.hibernate.Hibernate;
import org.mapstruct.MapperConfig;

import java.util.List;

/**
 * packageName    : com.study.ducky.config.mapstruct
 * fileName       : MapstructConfig
 * author         : patio
 * date           : 2023-09-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-16           patio            최초 생성
 */

// Hibernate jpa 기본 모듈.
@MapperConfig
public interface MapstructConfig {

    //  다 건
    default boolean isLoaded(List<? extends BaseEntity> entities) {
        // 초기화 여부 물어봄 - 사용되었니?
        return Hibernate.isInitialized(entities);
    }

    // 단 건
    default boolean isLoaded(BaseEntity entity) {
        return Hibernate.isInitialized(entity);
    }
}
