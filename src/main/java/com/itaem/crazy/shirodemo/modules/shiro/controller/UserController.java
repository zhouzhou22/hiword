package com.itaem.crazy.shirodemo.modules.shiro.controller;

import com.itaem.crazy.shirodemo.common.exception.ParamException;
import com.itaem.crazy.shirodemo.common.result.ReturnCode;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryUserCommand;
import com.itaem.crazy.shirodemo.modules.shiro.command.UpdatePwdCommand;
import com.itaem.crazy.shirodemo.modules.shiro.service.UserService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.controller
 * @Description:
 * @MClassName: UserController
 * @Authur: yangjianyi
 * @Date: 2020/4/17 15:58
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户", notes = "参数:姓名")
    @RequestMapping("/queryUserList")
    public SuccessResponse queryUserList(@RequestBody QueryUserCommand command) {
        SuccessResponse response = new SuccessResponse();
        try {
            response = userService.queryUserList(command);
        }catch (Exception e) {
            log.error("======查询用户错误：", ExceptionUtils.getFullStackTrace(e));
            response.setResultCode(ReturnCode.SERVER_ERROR.code());
            response.setMessage(ReturnCode.SERVER_ERROR.message());
        }
        return response;
    }

    @ApiOperation(value = "更新密码", notes = "参数:old密码，new密码")
    @RequestMapping("/updatePwd")
    public SuccessResponse updatePwdCommand(@Validated @RequestBody UpdatePwdCommand command,BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors())
        {
            throw new ParamException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        SuccessResponse response = new SuccessResponse();
        try {
            response = userService.updatePwd(command);
        }catch (Exception e) {
            log.error("======更新用户密码：", ExceptionUtils.getFullStackTrace(e));
            response.setResultCode(ReturnCode.SERVER_ERROR.code());
            response.setMessage(ReturnCode.SERVER_ERROR.message());
        }
        return response;
    }

}
