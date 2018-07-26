package com.ly.xiyifu.rest.interfaces;


import com.ly.xiyifu.model.BaseModel;

/**
 * 文件名称： ActionCallBack
 * <p>
 * 包路径： book.store.rest.interfaces
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:46
 * <p>
 * 修改记录：
 */
@FunctionalInterface
public interface ActionCallBack {

    Object action(BaseModel req);


}
