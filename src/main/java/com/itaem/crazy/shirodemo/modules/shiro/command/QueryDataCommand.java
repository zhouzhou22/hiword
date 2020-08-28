package com.itaem.crazy.shirodemo.modules.shiro.command;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * @ProjectName ：com.yangjy.demo.command
 * @Description:
 * @MClassName: QueryDataCommand
 * @Authur: yangjianyi
 * @Date: 2020/4/13 13:55
 */
@Data
@ToString
public class QueryDataCommand implements Serializable {
    /*1:tsp(B库) 2：tboss(C库)*/
    private Integer type;

    /*sql*/
    private String sql;

}
