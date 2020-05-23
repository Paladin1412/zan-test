package com.zan.hu.allocation.res.datasource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 15:09
 * @Description
 **/
@Data
@ApiModel("数据源响应对象")
public class FiDataSourceResponseList extends FiDataSourceResponse{

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("状态")
    private int status;

    @ApiModelProperty("创建日期")
    private Date gmtCreate;

    @ApiModelProperty("创建人")
    private String creator;
}
