package com.arpa.and.basearch.bean.base;

import java.util.List;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-05-31 01:25<br/>
 */
public class ResultPageData <T> {
    private int total;
    private int pageNum;
    private int pageSize;
    private List<T> records;

    public int getTotal() {
        return total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

}