package com.zan.hu.allocation.req;

import com.zan.hu.allocation.res.PagingObj;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 11/02
 */
@Data
@ApiModel("任务管理请求对象")
public class JobInstanceRequestList extends PagingObj {

    @ApiModelProperty("任务类型")
    String jobType;

    @ApiModelProperty("工号")
    String employeeNo;

    @ApiModelProperty("任务状态")
    Integer status;

}
