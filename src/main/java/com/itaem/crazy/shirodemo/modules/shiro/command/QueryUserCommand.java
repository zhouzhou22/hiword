package com.itaem.crazy.shirodemo.modules.shiro.command;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.command
 * @Description:
 * @MClassName: QueryUserCommand
 * @Authur: yangjianyi
 * @Date: 2020/4/17 16:04
 */
@Data
@ToString
public class QueryUserCommand extends BaseCommand implements Serializable {

    private String username;

    private String sno;

    private String phone;
}
