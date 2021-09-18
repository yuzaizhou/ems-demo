package com.winner.mes.ems.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author yzz
 * @date 2021/8/12
 * @description 字典数据封装类
 */
@Data
public class DictionaryVo {
    private List<MappingVo> mappingVoList;
    private List dataList;
}
