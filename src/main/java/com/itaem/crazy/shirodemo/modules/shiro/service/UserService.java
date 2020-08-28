package com.itaem.crazy.shirodemo.modules.shiro.service;

import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryUserCommand;
import com.itaem.crazy.shirodemo.modules.shiro.command.UpdatePwdCommand;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.service
 * @Description:
 * @MClassName: UserService
 * @Authur: yangjianyi
 * @Date: 2020/4/17 16:01
 */
public interface UserService {

    SuccessResponse queryUserList(QueryUserCommand command);

    SuccessResponse updatePwd(UpdatePwdCommand command);

}
