package com.winner.mes.ems.enums;

/**
 * @author yzz
 * @date 2021/8/4
 * @description
 */
public enum StatusEnum {
    ENABLE("1","已启用"),
    DISABLE("0","已禁用");
    private String code;

    private String name;

    StatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取角色名称
     * @param code
     * @return
     */
    public static String getNameByCode(String code){
        for (StatusEnum value : StatusEnum.values()) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }
}
