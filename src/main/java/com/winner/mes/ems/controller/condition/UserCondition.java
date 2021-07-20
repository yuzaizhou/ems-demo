package com.winner.mes.ems.controller.condition;

import com.winner.mes.ems.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Data
public class UserCondition extends BasePageQueryCondition{
    @ApiModelProperty(value = "人员编号")
    private String code;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
