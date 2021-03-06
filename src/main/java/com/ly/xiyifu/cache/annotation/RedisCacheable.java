package com.ly.xiyifu.cache.annotation; /**
 *
 * 文件名称： RedisCacheable
 *
 * 包路径： com.ly.platform.cache.annotation
 *
 * 版权所有：灵铱科技
 *
 * 类描述：
 *
 * 创建人： 程增辉
 *
 * 创建时间： 2018/07/11 - 11:19
 *
 * 修改记录：
 *
 */

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface RedisCacheable {
    String namespace();

    String key();//缓存主键前缀

    int expireTime() default 3600;
}