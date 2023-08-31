package com.study.ducky.aggreations.v1.order.enums;

import lombok.Getter;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.enums
 * fileName       : ItemStatusEnum
 * author         : patio
 * date           : 2023-08-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-31           patio            최초 생성
 */
@Getter
public enum ItemStatusEnum {
    SELL("팔기"),
    STOP("안팔기?중단?");

    private String status;

    ItemStatusEnum(String status){
        this.status = status;
    }
}
