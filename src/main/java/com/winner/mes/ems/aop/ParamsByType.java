package com.winner.mes.ems.aop;

import java.util.List;

/**
 * @author yzz
 * @date 2021/8/11
 * @description
 */
public interface ParamsByType<T> {
     List<T> dataByType(String type);
}
