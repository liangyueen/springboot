package com.ly.xiyifu.dao;


import com.ly.xiyifu.cache.annotation.RedisCacheEvict;
import com.ly.xiyifu.cache.annotation.RedisCacheable;
import com.ly.xiyifu.constants.Cache;
import com.ly.xiyifu.model.User;

/**
 * 文件名称： UserMapper
 * <p>
 * 包路径： book.store.mapper
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:23
 * <p>
 * 修改记录：
 */
public interface UserMapper extends BaseMapper<User> {

    @Override
    @RedisCacheable(namespace = Cache.CACHE_USER_NAME_SPACE, key = "args[0]", expireTime = 24 * 3600)
    User getByID(String id);

    @Override
    @RedisCacheEvict(namespace = Cache.CACHE_USER_NAME_SPACE, key = "args[0].userId")
    int update(User model);
}
