package com.study.ducky.aggreations.v1.order.presentation.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.study.ducky.aggreations.v1.order.presentation.dto.req
 * fileName       : result
 * author         : patio
 * date           : 2023-08-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-21           patio            최초 생성
 */
@Builder
@Getter
@Setter
public class Result {
    Object result;
    String message = "성공";
}
