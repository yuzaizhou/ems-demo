package com.winner.mes.ems.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winner.mes.ems.controller.vo.ParamVo;
import com.winner.mes.ems.entity.Param;
import com.winner.mes.ems.pojo.MappingVo;

import java.util.List;

/**
 * @author yzz
 * @date 2021/8/10
 * @description
 */
public interface ParamMapper extends BaseMapper<Param> {
    List<MappingVo> getParamListByTypeCode(@org.apache.ibatis.annotations.Param("mappingVoList") List<MappingVo> mappingVoList);
}
