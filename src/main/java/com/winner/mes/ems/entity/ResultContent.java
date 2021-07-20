package com.winner.mes.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultContent {
    private Integer code;

    private String status;

    private Object data;

    private String message;
}
