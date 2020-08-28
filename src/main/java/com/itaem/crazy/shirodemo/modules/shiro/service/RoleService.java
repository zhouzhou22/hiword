package com.itaem.crazy.shirodemo.modules.shiro.service;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryRoleCommand;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryRoleDetailCommand;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.service
 * @Description:
 * @MClassName: RoleService
 * @Authur: yangjianyi
 * @Date: 2020/6/11 9:34
 */
public interface RoleService {

    SuccessResponse queryRoleList(QueryRoleCommand command);

    SuccessResponse queryRoleDetail(QueryRoleDetailCommand command);
}
