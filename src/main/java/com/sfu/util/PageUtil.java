package com.sfu.util;

import java.util.List;

public class PageUtil<T> {

    private List<T> dataList;//数据

    private long pageNo;//当前页

    private long pageSize;//条数

    private long total;//总条数

    private long pages;//总页面数目

    public PageUtil() {

    }

    public PageUtil(List<T> dataList, long pageNo, long pageSize, long total) {
        this.dataList = dataList;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        if(pageSize==0) pages=1;
        else pages=total%pageSize==0?total/pageSize:total/pageSize+1;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

}
