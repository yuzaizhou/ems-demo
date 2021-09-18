package com.winner.mes.ems.aop;

import com.winner.mes.ems.pojo.DictionaryVo;
import com.winner.mes.ems.pojo.MappingVo;
import java.util.List;

/**
 * @author yzz
 * @date 2021/8/11
 * @description  数据字典转化接口
 */
public interface ParamsType {
     List<MappingVo> dataByType(List<MappingVo> mappingVoList);
}
