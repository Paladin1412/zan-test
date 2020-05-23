package com.zan.hu.allocation.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 14:22
 * @Description
 **/
@Data
@ApiModel("分页对象")
public class PagingObj<T> {

    @ApiModelProperty("总数")
    int total;

    @ApiModelProperty("当前页")
    int currentPage;

    @ApiModelProperty("页大小")
    int pageSize;

    @ApiModelProperty("data")
    List<T> data;


    public PagingObj(int total, int currentPage, int pageSize, List<T> t) {
        this.total = total;
        this.currentPage = 1;
        this.pageSize = 20;
        this.data = t;
    }
}
