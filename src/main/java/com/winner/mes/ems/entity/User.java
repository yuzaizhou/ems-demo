package com.winner.mes.ems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String code;
    private String userName;
    private String password;
    private String account;
    private String phone;
    private String email;
    private Date createTime;
    private int delFlag = 1;
}
