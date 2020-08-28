package com.itaem.crazy.shirodemo.modules.shiro.command;

import java.io.Serializable;
import lombok.Data;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.command
 * @Description:
 * @MClassName: QueryRoleCommand
 * @Authur: yangjianyi
 * @Date: 2020/6/11 9:35
 */
@Data
public class QueryRoleDetailCommand extends BaseCommand implements Serializable {

    private Integer roleId;
}
