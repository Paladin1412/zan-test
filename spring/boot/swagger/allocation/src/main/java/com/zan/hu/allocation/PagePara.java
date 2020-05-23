package com.zan.hu.allocation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 14:19
 * @Description
 **/
@Data
public class PagePara {

    @ApiModelProperty("size")
    private int size;

    @ApiModelProperty("pageNo")
    private int pageNo;
}
