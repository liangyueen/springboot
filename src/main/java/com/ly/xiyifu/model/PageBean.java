package com.ly.xiyifu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名称： PageBean
 * <p>
 * 包路径： book.stroe.model
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：分页数据载体
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 13:51
 * <p>
 * 修改记录：
 */
public class PageBean<T> {




    private int currentPage; // 当前页

    private int pageSize; // 每页显示多少条

    // 查询数据库

    private int recordCount; // 总记录数

    private List<T> recordList; // 本页的数据列表

    //SQL
    private int start;

    // 计算
    private int pageCount; // 总页数


    private List<Integer> pageNumList = new ArrayList<>();


    /**
     * 只接受前4个必要的属性，会自动的计算出其他3个属生的值
     *
     * @param currentPage
     * @param pageSize
     * @param recordCount
     */
    public PageBean(int currentPage, int pageSize, int recordCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.recordCount = recordCount;

        //

        this.start = (this.currentPage - 1) * pageSize;


        // 计算总页码
        pageCount = (recordCount + pageSize - 1) / pageSize;

        int beginPageIndex = 0; // 页码列表的开始索引（包含）
        int endPageIndex = 0; // 页码列表的结束索引（包含）

        // 计算 beginPageIndex 和 endPageIndex
        // >> 总页数不多于10页，则全部显示
        if (pageCount <= 10) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
            this.recordList = recordList;
        }
        // >> 总页数多于10页，则显示当前页附近的共10个页码
        else {
            // 当前页附近的共10个页码（前4个 + 当前页 + 后5个）
            beginPageIndex = currentPage - 4;
            endPageIndex = currentPage + 5;
            // 当前面的页码不足4个时，则显示前10个页码
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }
            // 当后面的页码不足5个时，则显示后10个页码
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = pageCount - 10 + 1;
            }
        }

        for (int num = beginPageIndex; num <= endPageIndex; num++) {
            this.pageNumList.add(num);
        }
    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<Integer> getPageNumList() {
        return pageNumList;
    }

    public void setPageNumList(List<Integer> pageNumList) {
        this.pageNumList = pageNumList;
    }


}