package com.itaem.crazy.shirodemo.modules.shiro.command;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * @ProjectName ：com.yangjy.demo.command
 * @Description:
 * @MClassName: QueryChartsCommand
 * @Authur: yangjianyi
 * @Date: 2020/4/1 17:40
 */
@Data
@ToString
public class QueryChartsCommand extends BaseCommand implements Serializable {

    private String stockName;

    private String startDateStr;

    private String endDateStr;

}
