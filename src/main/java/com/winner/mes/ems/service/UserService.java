package com.winner.mes.ems.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winner.mes.ems.annotation.CodeConvert;
import com.winner.mes.ems.annotation.CodeMapping;
import com.winner.mes.ems.controller.condition.UserCondition;
import com.winner.mes.ems.controller.vo.UserVo;
import com.winner.mes.ems.dao.mapper.UserMapper;
import com.winner.mes.ems.entity.User;
import com.winner.mes.ems.utils.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisUtil redisUtil;

    @CodeConvert(data = ParamsTypeImpl.class, mapping = @CodeMapping(source = "status", target = "email"))
    public IPage<UserVo> getListQuery(UserCondition userCondition) {
        Page page = new Page<>(userCondition.getPageNo(), userCondition.getPageSize());
        Page<UserVo> userList = userMapper.selectPageListVo(page, userCondition);
        return userList;
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertUserRedis(User user) {
        redisUtil.set(user.getCode(), user, 1000);
        userMapper.insert(user);
        return 1;
    }
}
