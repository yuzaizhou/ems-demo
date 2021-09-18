package com.winner.mes.ems.enums;

/**
 * @author yzz
 * @date 2021/8/12
 * @description 字典类型
 */
public enum DictionaryEnum {
    STATUS("status", "BM_STATUS_CODE"),
    ACTIVED("actived", "BM_STATUS_CODE"),
    SOURCE("source", "BM_STATUS_CODE"),
    TYPE("type", "BM_TYPE_CODE");

    private String code;

    private String name;

    DictionaryEnum(String code, String name) {
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
     * 获取名称
     *
     * @param code
     * @return
     */
    public static String getNameByCode(String code) {
        for (DictionaryEnum value : DictionaryEnum.values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
            }
        }
        return null;
    }
}
