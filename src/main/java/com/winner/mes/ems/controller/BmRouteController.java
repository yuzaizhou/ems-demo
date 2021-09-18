package com.winner.mes.ems.controller;

import com.purcotton.mes.mdm.controller.BmRouteControllerDeclare;
import com.purcotton.mes.mdm.request.BmRouteRequest;
import com.purcotton.mes.mdm.response.BmRouteResponse;
import com.purcotton.obj.response.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yzz
 * @date 2021/7/20
 * @description
 */
@RestController
public class BmRouteController implements BmRouteControllerDeclare {
    @Override
    @ApiOperation("新罗马代码设计器测试")
    public ResponseData<List<BmRouteResponse>> getList(BmRouteRequest bmRouteRequest) {
        return null;
    }
}
