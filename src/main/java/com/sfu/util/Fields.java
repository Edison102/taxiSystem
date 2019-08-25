package com.sfu.util;


public class Fields {
    public static int pageSize=2;  //分页的页面大小

    public static int getStart(int page){
        return (page-1)*Fields.pageSize;
    }
}
