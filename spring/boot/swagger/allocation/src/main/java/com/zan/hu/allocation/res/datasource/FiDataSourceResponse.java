package com.zan.hu.allocation.res.datasource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 15:04
 * @Description
 **/
@Data
@ApiModel("数据源响应对象")
public class FiDataSourceResponse implements Serializable {
    @ApiModelProperty("数据源Id")
    private long id;

    @ApiModelProperty("数据源名称")
    private String name;

    @ApiModelProperty("表名")
    private String tableName;

    @ApiModelProperty("数据库类型")
    private String databaseType;

    @ApiModelProperty("来源")
    private int source;
}
