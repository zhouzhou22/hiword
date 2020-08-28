package com.itaem.crazy.shirodemo.common.result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/10/11.
 */
public enum ReturnCode implements InterfaceResultCode {

    OK(200, "OK"), NO_DATA(511, "NO DATA"), CLIENT_ERROR(507, "Client Error"), FORBIDDEN(510,
            "Forbidden"), SERVER_ERROR(
            506, "Server Error"), LOGIN_FAIL(509, "登录失败！"), USER_DNE(508, "User Does Not Exist"), USER_NOT_ONLINE(509,
            "User Not Online"), VALIDATE_MSG_FAIL(510, "参数校验失败"), BASECOMMAND_NOT_UIL(520,
            "BaseCommand 不允许为空 ."), PARA_MUST_CONTAIN_BASECOMMAND(521, "必须含有类型为BaseCommand的参数 ."), PARA_ERROR(522,
            "参数有误 ."), NI_CLOUD_ERROR(523, "调用位置云接口异常，异常信息："), UNKNOWN_ERROR(650599, "未知异常"),
            NOT_PERMISSION(400, "对不起，您的权限有误");

    private static Map<Integer, ReturnCode> codes = new ConcurrentHashMap<Integer, ReturnCode>();

    static {
        for (ReturnCode errorCodeEnum : ReturnCode.values()) {
            codes.put(errorCodeEnum.code(), errorCodeEnum);
        }
    }

    ReturnCode(int code) {
        this.code = code;
    }

    ReturnCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    private String message;

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static ReturnCode valueOf(int code) {
        if (codes.get(code) != null) {
            return codes.get(code);
        } else {
            return UNKNOWN_ERROR;
        }
    }

}
