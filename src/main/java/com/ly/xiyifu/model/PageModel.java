package com.ly.xiyifu.model;

import lombok.Data;

/**
 * 文件名称： PageModel
 * <p>
 * 包路径： book.store.model
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 15:49
 * <p>
 * 修改记录：
 */
@Data
public class PageModel extends BaseModel {

    private int currentPage;

    private int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
