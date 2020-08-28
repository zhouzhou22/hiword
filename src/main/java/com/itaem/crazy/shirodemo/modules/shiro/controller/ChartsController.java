package com.itaem.crazy.shirodemo.modules.shiro.controller;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryChartsCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itaem.crazy.shirodemo.modules.shiro.service.impl.ChartsServiceImpl;

/**
 * @ProjectName ：com.yangjy.demo.controller
 * @Description:
 * @MClassName: ChartsController
 * @Authur: yangjianyi
 * @Date: 2020/4/1 17:05
 */
@RestController
@RequestMapping("/charts")
public class ChartsController {

    private static final Logger log = LoggerFactory.getLogger(ChartsController.class);
    @Autowired
    private ChartsServiceImpl chartsService;

    /**
     *查询折现数据
     * @param queryChartsCommand
     * @return
     */
    @RequestMapping("/query")
    public SuccessResponse queryChartsList(@RequestBody QueryChartsCommand queryChartsCommand) {
        log.info("=============参数："+queryChartsCommand.toString());
        return chartsService.queryChartsList(queryChartsCommand);
    }

    /**
     *
     * @param addChartsCommand
     * @return
     */
    /*@RequestMapping("/add")
    public SuccessResponse AddCharts(@RequestBody AddChartsCommand addChartsCommand) {
        return chartsService.AddCharts(addChartsCommand);
    }

    @RequestMapping("/queryStockNameList")
    public SuccessResponse queryStockNameList() {
        return chartsService.queryStockNameList();
    }*/
}
