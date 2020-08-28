package com.itaem.crazy.shirodemo.common.exception;

import com.itaem.crazy.shirodemo.common.result.InterfaceResultCode;

/**
 * Created by zhangdong on 2017/5/19.
 */
public class ParamException extends BaseException {
    public ParamException() {
    }

    public ParamException(InterfaceResultCode resultCode) {
        super(resultCode);
    }

    public ParamException(int code, String message) {
        super(code, message);
    }

    public ParamException(int code) {
        super(code);
    }

    public ParamException(String message) {
        super(message);
    }
}
