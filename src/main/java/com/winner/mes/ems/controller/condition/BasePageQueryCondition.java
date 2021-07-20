package com.winner.mes.ems.controller.condition;

import lombok.Data;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Data
public class BasePageQueryCondition {
   private int pageNo = 1;
   private int pageSize = 5;
}
