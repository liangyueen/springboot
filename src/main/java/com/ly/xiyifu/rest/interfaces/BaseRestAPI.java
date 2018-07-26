package com.ly.xiyifu.rest.interfaces;


import book.store.utils.ValidatorUtils;
import com.ly.xiyifu.model.BaseModel;
import com.ly.xiyifu.rest.base.Response;
import com.ly.xiyifu.rest.base.ResponseStatus;
import com.ly.xiyifu.rest.exception.GlobalControllerExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 文件名称： BaseRestAPI
 * <p>
 * 包路径： book.store.rest.interfaces
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:42
 * <p>
 * 修改记录：
 */
public class BaseRestAPI {

    private Logger logger = Logger.getLogger(BaseRestAPI.class);

    public <R extends BaseModel> Response action(R req, ActionCallBack action) {

        try {
            String vstr = ValidatorUtils.validate(req);
            if (StringUtils.isNotBlank(vstr)) {
                return new Response(ResponseStatus.RESPONSE_USER_VALIDATE_EXCEPTION.getCode(), vstr);
            }

            Object result = action.action(req);
            Response response = new Response(ResponseStatus.SUCCESS);

            response.bindData(result);

            return response;
        } catch (Exception e) {
            logger.error(e);
            Response response = GlobalControllerExceptionHandler.resolveExceptionCustom(e);
            return response;
        }
    }

}
