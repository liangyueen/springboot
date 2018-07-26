package com.ly.xiyifu.service.impl;


import com.ly.xiyifu.dao.BaseMapper;
import com.ly.xiyifu.dao.UserMapper;
import com.ly.xiyifu.model.User;
import com.ly.xiyifu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 文件名称： UserServiceImpl
 * <p>
 * 包路径： book.stroe.service.interfaces.impl
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
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public void saveUser(User req) {
        req.setCreateTime(new Date());
        this.save(req);

    }
}
