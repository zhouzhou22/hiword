package com.itaem.crazy.shirodemo.modules.shiro.controller;

import com.itaem.crazy.shirodemo.common.exception.ParamException;
import com.itaem.crazy.shirodemo.common.result.ReturnCode;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.UpdatePwdCommand;
import com.itaem.crazy.shirodemo.modules.shiro.service.PermissionService;
import io.swagger.annotations.ApiOperation;
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
 * @MClassName: PermissionController
 * @Authur: yangjianyi
 * @Date: 2020/4/23 16:36
 */
@RestController
@RequestMapping("/permission")
@Slf4j
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @ApiOperation(value = "获取权限菜单", notes = "")
    @RequestMapping("/queryPermissionList")
    public SuccessResponse queryPermissionList() {
        SuccessResponse response = new SuccessResponse();
        try {
            response = permissionService.queryPermissionList();
        }catch (Exception e) {
            log.error("======获取权限菜单：", ExceptionUtils.getFullStackTrace(e));
            response.setResultCode(ReturnCode.SERVER_ERROR.code());
            response.setMessage(ReturnCode.SERVER_ERROR.message());
        }
        return response;
    }
}
