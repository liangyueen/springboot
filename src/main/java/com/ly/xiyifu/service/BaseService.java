package com.ly.xiyifu.service;


import com.ly.xiyifu.model.PageBean;

import java.util.List;

/**
 * 文件名称： BaseService
 * <p>
 * 包路径： book.stroe.service.interfaces
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：定义基本的增删改查方法
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 13:51
 * <p>
 * 修改记录：
 */
public interface BaseService<T> {
    /**
     * 添加
     *
     * @param model
     */

    void save(T model);

    /**
     * *
     * 删除
     *
     * @param id 一般情况下为主键
     */

    int remove(String id);

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
    PageBean<T> page(T model, int currentPage, int pageSize);

}
