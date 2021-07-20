package com.winner.mes.ems.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winner.mes.ems.annotation.ResultWrapper;
import com.winner.mes.ems.controller.condition.UserCondition;
import com.winner.mes.ems.controller.vo.UserVo;
import com.winner.mes.ems.entity.User;
import com.winner.mes.ems.service.UserService;
import com.winner.mes.ems.utils.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("查询用户列表")
    @PostMapping("/user/search")
    @ResultWrapper
    public IPage<UserVo> getList(@RequestBody UserCondition userCondition) {
        IPage<UserVo> list = userService.getListQuery(userCondition);
        return list;
    }

    @ApiOperation("redis测试")
    @PostMapping("/redis/test")
    @ResultWrapper
    public int insertUserRedis(@RequestBody User user) {
        return userService.insertUserRedis(user);
    }
}
