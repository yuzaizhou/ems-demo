package com.winner.mes.ems.service;

import com.winner.mes.ems.aop.ParamsType;
import com.winner.mes.ems.controller.vo.ParamVo;
import com.winner.mes.ems.dao.mapper.ParamMapper;
import com.winner.mes.ems.entity.Param;
import com.winner.mes.ems.enums.DictionaryEnum;
import com.winner.mes.ems.pojo.DictionaryVo;
import com.winner.mes.ems.pojo.MappingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yzz
 * @date 2021/8/11
 * @description
 */
@Service
public class ParamsTypeImpl implements ParamsType {
    @Resource
    private ParamMapper paramMapper;

    @Override
    public List<MappingVo> dataByType(List<MappingVo> mappingVoList) {
        mappingVoList.forEach(item -> {
            item.setDataTypeCode(DictionaryEnum.getNameByCode(item.getSource()));
        });
        List<MappingVo> paramList = paramMapper.getParamListByTypeCode(mappingVoList);
        if (paramList == null || paramList.size() == 0) {
            throw new RuntimeException("字典数据错误！");
        }
        paramList.stream().map(var1 -> mappingVoList.stream()
                .filter(var2 -> var1.getDataTypeCode().equals(var2.getDataTypeCode()))
                .findAny()
                .map(var2 -> {
                    var1.setSource(var2.getSource());
                    var1.setTarget(var2.getTarget());
                    return var1;
                }).orElse(null))
                .collect(Collectors.toList());
        return paramList;
    }
}
