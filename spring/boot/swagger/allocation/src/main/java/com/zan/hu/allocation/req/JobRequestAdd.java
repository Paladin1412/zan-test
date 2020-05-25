package com.zan.hu.allocation.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 11/20
 */
@Data
@ApiModel("新增任务")
public class JobRequestAdd {

    @ApiModelProperty("活动ID")
    Long activityId;

    @ApiModelProperty("任务类型")
    String jobType;

    @ApiModelProperty("调度类型")
    String scheduleType;

    @ApiModelProperty("时间表达式")
    String timingExpression;

    @ApiModelProperty("参数")
    String params;

}
