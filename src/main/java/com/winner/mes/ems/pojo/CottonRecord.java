package com.winner.mes.ems.pojo;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author yzz
 * @date 2021/8/25
 * @description
 */
@Data
public class CottonRecord {
    private Integer row1;
    private Integer row2;
    private String cottonLot1;
    private String cottonLot2;
    private String commodityBarCode;
    private String convertedQtyUm;
    private String unitQty;
    private String convertedQty;
    private String fromLoc;
    private String toLoc;
}
