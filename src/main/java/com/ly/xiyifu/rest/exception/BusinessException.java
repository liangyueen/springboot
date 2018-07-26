package com.ly.xiyifu.rest.exception;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * User: chengzh
 * <p>
 * Date: 18-3-15 Time: 下午5:32
 * <p>
 * Description:
 */
@Data
public class BusinessException extends RuntimeException {

    private int errCode;

    private String msg;

    public BusinessException(int code, String msg) {
        super(msg);
        this.errCode = code;
        this.msg = msg;
    }


}