package com.ly.xiyifu.rest.exception;


import com.ly.xiyifu.rest.base.Response;
import com.ly.xiyifu.rest.base.ResponseStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件名称： GlobalControllerExceptionHandler
 * <p>
 * 包路径： book.store.rest.exception
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 15:10
 * <p>
 * 修改记录：
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Response allExceptionHandler(Exception exception) {
        return GlobalControllerExceptionHandler.resolveExceptionCustom(exception);
    }




    // 异常信息解析方法
    public static Response resolveExceptionCustom(Exception ex) {
        ex.printStackTrace();
        //TODO 可以扩展更多异常类型解析
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            return new Response(businessException.getErrCode(), businessException.getMsg());
        } else if (ex instanceof BindException) {
            BindException methodArgumentNotValidException = (BindException) ex;

            List<String> error = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());

            Response response = new Response(ResponseStatus.ERROR);
            response.setMsg(StringUtils.join(error.toArray(), ","));
            return response;
        } else {
            return new Response(ResponseStatus.ERROR);
        }
    }


}
