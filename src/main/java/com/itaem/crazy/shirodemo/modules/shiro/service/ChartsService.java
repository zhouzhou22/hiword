package com.itaem.crazy.shirodemo.modules.shiro.service;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryChartsCommand;


/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.service
 * @Description:
 * @MClassName: ChartsService
 * @Authur: yangjianyi
 * @Date: 2020/4/16 14:44
 */
public interface ChartsService {

    public SuccessResponse queryChartsList(QueryChartsCommand queryChartsCommand);

    /*public SuccessResponse AddCharts(AddChartsCommand addChartsCommand);

    public SuccessResponse queryStockNameList();*/
}
