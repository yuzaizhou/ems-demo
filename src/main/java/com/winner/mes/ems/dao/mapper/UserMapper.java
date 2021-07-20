package com.winner.mes.ems.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winner.mes.ems.controller.condition.UserCondition;
import com.winner.mes.ems.controller.vo.UserVo;
import com.winner.mes.ems.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserMapper extends BaseMapper<User> {
    Page<UserVo> selectPageListVo(Page<UserVo> page, @Param("userCondition") UserCondition userCondition);
}
