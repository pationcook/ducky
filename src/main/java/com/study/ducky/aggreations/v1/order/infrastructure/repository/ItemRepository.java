package com.study.ducky.aggreations.v1.order.infrastructure.repository;

import com.study.ducky.aggreations.v1.order.domain.ItemAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.infrastructure.repository
 * fileName       : ItemRepository
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemAggregate, Long> {
    // simple jpaRepo에서 구현부 제공.
    // sql => jpql 로 동작. ->  문법이 조금 다름.
    // jpql은 sql과 같은놈이나 객체로 접근이 가능하다.
    // Optional<ENTITY>  해당 객체에 옵션여부 체크.
}
