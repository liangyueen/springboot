/**
 *
 * 文件名称：  RedisCacheEvict
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

package com.ly.xiyifu.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCacheEvict {
    String namespace();

    String key();


}