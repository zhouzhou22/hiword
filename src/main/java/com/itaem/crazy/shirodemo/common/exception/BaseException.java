package com.itaem.crazy.shirodemo.common.exception;

import com.itaem.crazy.shirodemo.common.result.InterfaceResultCode;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by liguowang on 2020/1/10.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private int code = -1;
    private String message = "操作失败";

    public BaseException(InterfaceResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(int code){
        this.code = code;
    }

    public BaseException(String message){
        this.message = message;
    }
}