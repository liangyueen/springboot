package com.ly.xiyifu.rest.base;

import lombok.Data;

/**
 * 文件名称： Response
 * <p>
 * 包路径： book.store.rest.base
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:37
 * <p>
 * 修改记录：
 */
@Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;



    public static Response ok = new Response(ResponseStatus.SUCCESS);

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public Response bindData(T data) {
        this.data = data;
        return this;
    }
}
