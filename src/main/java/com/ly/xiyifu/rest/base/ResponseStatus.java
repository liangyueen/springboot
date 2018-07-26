package com.ly.xiyifu.rest.base;

import lombok.Data;

/**
 * 文件名称： ResponseStatus
 * <p>
 * 包路径： book.store.rest.base
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:38
 * <p>
 * 修改记录：
 */
@Data
public final class ResponseStatus {

    private int code;

    private String msg;

    public ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static final ResponseStatus SUCCESS = new ResponseStatus(10000, "成功");
    public static final ResponseStatus ERROR = new ResponseStatus(20000, "失败");
    public static final ResponseStatus WARNING = new ResponseStatus(30000, "警告");
    public static final ResponseStatus RESPONSE_USER_VALIDATE_EXCEPTION = new ResponseStatus(40000, "参数验证错误");

}
