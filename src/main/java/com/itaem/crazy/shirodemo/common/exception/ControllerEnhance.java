package com.itaem.crazy.shirodemo.common.exception;

import com.itaem.crazy.shirodemo.common.result.ReturnCode;
import com.itaem.crazy.shirodemo.common.result.SuccessResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by zhangdong on 2017/5/18.
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ControllerEnhance {

    // 定义全局异常处理，value属性可以过滤拦截条件，此处拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public SuccessResponse handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        if (ex instanceof ParamException) {
            //异常内容
            return new SuccessResponse(ReturnCode.PARA_ERROR.code(), ex.getMessage());
        }
        if (ex instanceof ServletRequestBindingException) {
            return new SuccessResponse(ReturnCode.PARA_ERROR.code(), "参数异常");
        }
        if (ex instanceof NoHandlerFoundException) {
            return new SuccessResponse(ReturnCode.PARA_ERROR.code(), "请求资源未找到");
        }
        if (ex instanceof HttpMediaTypeNotSupportedException) {
            return new SuccessResponse(ReturnCode.PARA_ERROR.code(), "媒体类型不支持");
        }
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return new SuccessResponse(ReturnCode.PARA_ERROR.code(), "请求方法不正确");
        }
        return new SuccessResponse(ReturnCode.PARA_ERROR.code(), "服务器内部异常");

    }

}
