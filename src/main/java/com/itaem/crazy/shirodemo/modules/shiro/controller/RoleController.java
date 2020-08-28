package com.itaem.crazy.shirodemo.modules.shiro.controller;

import com.itaem.crazy.shirodemo.common.result.ReturnCode;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryRoleCommand;
import com.itaem.crazy.shirodemo.modules.shiro.command.QueryRoleDetailCommand;
import com.itaem.crazy.shirodemo.modules.shiro.service.RoleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.controller
 * @Description:
 * @MClassName: RoleController
 * @Authur: yangjianyi
 * @Date: 2020/4/20 10:05
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "查询角色", notes = "参数:角色名称")
    @RequestMapping("/queryRoleList")
    public  @ResponseBody SuccessResponse queryRoleList(@RequestBody QueryRoleCommand command) {
        SuccessResponse response = new SuccessResponse();
        try {
            response = roleService.queryRoleList(command);
        }catch (Exception e) {
            log.error("======查询角色错误：", ExceptionUtils.getFullStackTrace(e));
            response.setResultCode(ReturnCode.SERVER_ERROR.code());
            response.setMessage(ReturnCode.SERVER_ERROR.message());
        }
        return response;
    }

    @ApiOperation(value = "查询角色详情", notes = "参数:角色id")
    @RequestMapping("/queryRoleDetail")
    public  @ResponseBody SuccessResponse queryRoleDetail(@RequestBody QueryRoleDetailCommand command) {
        SuccessResponse response = new SuccessResponse();
        try {
            response = roleService.queryRoleDetail(command);
        }catch (Exception e) {
            log.error("======查询角色详情错误：", ExceptionUtils.getFullStackTrace(e));
            response.setResultCode(ReturnCode.SERVER_ERROR.code());
            response.setMessage(ReturnCode.SERVER_ERROR.message());
        }
        return response;
    }

}
