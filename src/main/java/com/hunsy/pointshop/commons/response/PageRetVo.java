package com.hunsy.pointshop.commons.response;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageRetVo<T> implements Serializable {

    private Long totalNum;
    private Integer totalPage;
    private Integer currentPage;
    private List<T> dataResult = new ArrayList<>();

    public PageRetVo(PageInfo<T> pageInfo) {
        this.currentPage = pageInfo.getPageNum();
        this.totalNum = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
        if (pageInfo.getList() != null) {
            this.dataResult.addAll(pageInfo.getList());
        }
    }

    public PageRetVo(Long totalNum, Integer totalPage, Integer currentPage, List<T> dataResult) {
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        if (dataResult != null) {
            this.dataResult.addAll(dataResult);
        }

        this.currentPage = currentPage;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataResult() {
        return dataResult;
    }

    public void setDataResult(List<T> dataResult) {
        this.dataResult = dataResult;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
