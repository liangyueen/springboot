package com.ly.xiyifu.dao;

import com.ly.xiyifu.model.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件名称： BaseMapper
 * <p>
 * 包路径： book.store.mapper
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:09
 * <p>
 * 修改记录：
 */
public interface BaseMapper<T> {

    /**
     * 插入数据
     *
     * @param model
     */
    void insert(T model);

    /**
     * *
     * 删除数据根据id
     *
     * @param id 一般情况下为主键
     */

    int delete(String id);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */

    T getByID(String id);


    /**
     * *
     * 更新不为空的属性
     *
     * @param model
     */
    int update(T model);


    /**
     * 更新对象所有字段
     *
     * @param model
     */
    int updateAll(T model);

    /**
     * 根据条件求count
     *
     * @param model
     * @return
     */
    int count(T model);


    /**
     * *
     * 根据条件查询数据列表
     *
     * @param model
     * @return
     */
    List<T> list(T model);

    /**
     * 根据条件获取分页数据
     *
     * @param model
     * @return
     */
    List<T> listByPage(@Param("model") T model, @Param("page") PageBean page);


}
