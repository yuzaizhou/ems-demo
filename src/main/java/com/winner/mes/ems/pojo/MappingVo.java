package com.winner.mes.ems.pojo;

import lombok.Data;

/**
 * @author yzz
 * @date 2021/8/12
 * @description 字典编码与属性名的映射
 */
@Data
public class MappingVo {
    private String source;
    private String target;
    private String code;
    private String name;
    private String dataTypeCode;
}
