package com.zan.hu.allocation.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 16:36
 * @Description
 **/
@Data
@ApiModel("新增or编辑分摊活动")
public class AllocationActivityRequestAdd {
    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("活动编码")
    private String activityCode;

    @ApiModelProperty("数据源类型")
    private String databaseType;

    @ApiModelProperty("待分摊数据")
    private AllocationData allocationData;

    @ApiModelProperty("分摊因子")
    private DriverFactor driverFactor;

    @ApiModelProperty("附加关联")
    private AppendRelation appendRelation;

    @ApiModelProperty("分摊结果")
    private AllocationResult allocationResult;

    /**
     * 待分摊数据
     */
    @Data
    @ApiModel("待分摊数据")
    public class AllocationData {
        @ApiModelProperty("数据源名称")
        private String databaseName;

        @ApiModelProperty("过滤条件")
        private String filterCondition;

        @ApiModelProperty("待分摊字段")
        private String allocationFiled;

        @ApiModelProperty("运行参数")
        private String operatingParameter;
    }

    /**
     * 分摊因子
     */
    @Data
    @ApiModel("分摊因子")
    public class DriverFactor {
        @ApiModelProperty("数据源名称")
        private String databaseName;

        @ApiModelProperty("关联逻辑")
        private String relationLogic;

        @ApiModelProperty("分摊公式")
        private String allocationFormula;
    }

    /**
     * 附加关联
     */
    @Data
    @ApiModel("附加关联")
    public class AppendRelation {
        @ApiModelProperty("数据源名称")
        private String databaseName;

        @ApiModelProperty("关联对象")
        private String relationObj;

        @ApiModelProperty("关联逻辑")
        private String relationLogic;
    }

    /**
     * 分摊结果
     */
    @Data
    @ApiModel("分摊结果")
    public class AllocationResult {
        @ApiModelProperty("摘要")
        private String summary;

        @ApiModelProperty("行字段")
        private List<String> lineFiled;
    }
}
