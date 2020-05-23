package com.zan.hu.allocation.res.allocationactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 15:48
 * @Description
 **/
@Data
public class AllocationActivityResponseList {

    @ApiModelProperty("数据源Id")
    private long id;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("活动编码")
    private String activityCode;

    @ApiModelProperty("数据库类型")
    private String databaseType;

    @ApiModelProperty("状态")
    private int status;

    @ApiModelProperty("创建日期")
    private Date gmtCreate;

    @ApiModelProperty("创建人")
    private String creator;
}
