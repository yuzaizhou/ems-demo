package com.winner.mes.ems.controller.vo;

import com.winner.mes.ems.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @author yzz
 * @date 2021/7/12
 * @description
 */
@Data
public class UserVo{
    private StatusDesc statusDesc;
    private StatusDesc typeDesc;
    private StatusDesc sexDesc;
    private Long id;
    private String code;
    private String userName;
    private String password;
    private String account;
    private String phone;
    private String email;
    private Date createTime;
    private String status ;
    private Integer type ;
    private Integer sex = 1;
    private int delFlag = 1;

}
