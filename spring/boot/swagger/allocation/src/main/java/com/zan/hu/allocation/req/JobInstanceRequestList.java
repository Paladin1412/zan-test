package com.zan.hu.allocation.req;

import com.zan.hu.allocation.PagePara;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 11/02
 */
@ApiModel("任务管理请求对象")
@Data
public class JobInstanceRequestList extends PagePara {

    @ApiModelProperty("任务类型")
    String jobType;

    @ApiModelProperty("工号")
    String employeeNo;

    @ApiModelProperty("任务状态")
    Integer status;
}
