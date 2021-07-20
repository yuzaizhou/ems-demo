package com.winner.mes.ems.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winner.mes.ems.annotation.ResultWrapper;
import com.winner.mes.ems.controller.condition.UserCondition;
import com.winner.mes.ems.controller.vo.UserVo;
import com.winner.mes.ems.service.MQService;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yzz
 * @date 2021/7/13
 * @description
 */
@RestController
public class MQController {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private MQService mqService;

    @PostMapping("/mq/send")
    @ResultWrapper
    public boolean sendMes() {
        return mqService.sendMes();
    }
}
