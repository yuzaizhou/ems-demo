package com.winner.mes.ems.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.winner.mes.ems.dao.mapper.ParamMapper;
import com.winner.mes.ems.entity.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzz
 * @date 2021/8/10
 * @description
 */
@Service
public class ParamService {
    @Resource
    private ParamMapper paramMapper;

    public List<Param> getMapQuery(String type) {
        List<Param> map = paramMapper.selectList(Wrappers.<Param>lambdaQuery()
                .eq(Param::getType, type));
        return map;
    }

}
