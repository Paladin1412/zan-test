package com.zan.hu.allocation.res.allocationactivity;

import com.zan.hu.allocation.req.AllocationActivityRequestAdd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 16:32
 * @Description
 **/
@Data
public class AllocationActivityResponseGetById {

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("活动编码")
    private String activityCode;

    @ApiModelProperty("数据库类型")
    private String databaseType;

    @ApiModelProperty("状态")
    private int status;

    @ApiModelProperty("待分摊数据")
    private AllocationActivityRequestAdd.AllocationData allocationData;

    @ApiModelProperty("分摊因子")
    private AllocationActivityRequestAdd.DriverFactor driverFactor;

    @ApiModelProperty("附加关联")
    private AllocationActivityRequestAdd.AppendRelation appendRelation;

    @ApiModelProperty("分摊结果")
    private AllocationActivityRequestAdd.AllocationResult allocationResult;
}
