package com.winner.mes.ems.controller;

import com.purcotton.mes.mdm.controller.BmRouteControllerDeclare;
import com.purcotton.mes.mdm.request.BmRouteRequest;
import com.purcotton.mes.mdm.response.BmRouteResponse;
import com.purcotton.obj.response.ResponseData;

import java.util.List;

/**
 * @author yzz
 * @date 2021/7/20
 * @description
 */
public class BmRouteController implements BmRouteControllerDeclare {
    @Override
    public ResponseData<List<BmRouteResponse>> getList(BmRouteRequest bmRouteRequest) {
        return null;
    }
}
