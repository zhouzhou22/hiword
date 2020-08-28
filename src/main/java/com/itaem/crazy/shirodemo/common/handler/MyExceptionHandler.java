package com.itaem.crazy.shirodemo.common.handler;

import com.itaem.crazy.shirodemo.common.result.ReturnCode;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public SuccessResponse handleException(AuthorizationException e) {
        //e.printStackTrace();
        SuccessResponse error = new SuccessResponse();
        error.setResultCode(ReturnCode.NOT_PERMISSION.code());
        //获取错误中中括号的内容
        String message = e.getMessage();
        String msg=message.substring(message.indexOf("[")+1,message.indexOf("]"));
        //判断是角色错误还是权限错误
        if (message.contains("role")) {
            error.setMessage("对不起，您没有" + msg + "角色");
        } else if (message.contains("permission")) {
            error.setMessage("对不起，您没有" + msg + "权限");
        } else {
            error.setMessage(ReturnCode.NOT_PERMISSION.message());
        }
        return error;
    }
}
