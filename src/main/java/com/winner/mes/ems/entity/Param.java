package com.winner.mes.ems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yzz
 * @date 2021/8/10
 * @description
 */
@Data
public class Param {
    @TableId(type = IdType.AUTO)
    private String id;
    private String code;
    private String name;
    private String type;
    private Integer status;
}
