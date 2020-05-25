package com.zan.hu.allocation.res.job;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 11/09
 */
@Data
@ApiModel
public class JobResponseList {

    @ApiModelProperty("主键")
    Long id;

    @ApiModelProperty("任务名称")
    String jobName;

    @ApiModelProperty("运行参数")
    String params;

    @ApiModelProperty("运行状态")
    Integer status;

    @ApiModelProperty("提交时间")
    Date gmtCreate;

    @ApiModelProperty("执行人")
    String executor;

    @ApiModelProperty("完成时间")
    Date endTime;
}
