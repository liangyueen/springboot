package com.ly.xiyifu.service.impl;
import com.ly.xiyifu.dao.BaseMapper;
import com.ly.xiyifu.model.PageBean;
import com.ly.xiyifu.service.BaseService;

import java.util.List;

/**
 * 文件名称： BaseServiceImpl
 * <p>
 * 包路径： book.stroe.service.interfaces.impl
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:14
 * <p>
 * 修改记录：
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getMapper();


    @Override
    public void save(T model) {
        getMapper().insert(model);
    }

    @Override
    public int remove(String id) {
        return getMapper().delete(id);
    }

    @Override
    public T getByID(String id) {
        return getMapper().getByID(id);
    }

    @Override
    public int update(T model) {
        return getMapper().update(model);
    }

    @Override
    public int updateAll(T model) {
        return getMapper().updateAll(model);
    }

    @Override
    public int count(T model) {
        return getMapper().count(model);
    }

    @Override
    public List<T> list(T model) {
        return getMapper().list(model);
    }

    @Override
    public PageBean<T> page(T model, int currentPage, int pageSize) {
        int count = getMapper().count(model);
        PageBean page = new PageBean(currentPage, pageSize, count);
        List<T> list = getMapper().listByPage(model, page);
        page.setRecordList(list);
        return page;
    }
}
