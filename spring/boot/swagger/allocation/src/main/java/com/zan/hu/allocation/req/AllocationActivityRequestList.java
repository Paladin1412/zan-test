package com.zan.hu.allocation.req;

import com.zan.hu.allocation.PagePara;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 15:45
 * @Description
 **/
@Data
@ApiModel("分摊活动请求对象")
public class AllocationActivityRequestList extends PagePara {

    @ApiModelProperty("活动名称")
    String activityName;

    @ApiModelProperty("活动编码")
    String activityCode;

}

