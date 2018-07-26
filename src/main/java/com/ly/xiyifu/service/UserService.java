package com.ly.xiyifu.service;


import com.ly.xiyifu.model.User;

/**
 * 文件名称： UserService
 * <p>
 * 包路径： book.stroe.service.interfaces
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:33
 * <p>
 * 修改记录：
 */
public interface UserService extends BaseService<User> {
    void saveUser(User req);
}
