package com.itaem.crazy.shirodemo.modules.shiro.command;

import java.io.Serializable;
import lombok.Data;

/**
 * @ProjectName ：com.yangjy.demo.command
 * @Description:
 * @MClassName: AddChartsCommand
 * @Authur: yangjianyi
 * @Date: 2020/4/2 9:36
 */

@Data
public class AddChartsCommand implements Serializable {

    private String stockName;

    private String dateStr;

    private double price;

    public String getStockName() {
        return stockName;
    }
}
