package com.zan.hu.allocation.req;

import com.zan.hu.allocation.PagePara;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 16:59
 * @Description
 **/
@Data
@ApiModel("数据源列表请求对象")
public class DataSourceRequestList extends PagePara {

    @ApiModelProperty("数据源名称")
    String name;

    @ApiModelProperty("表名")
    String tableName;
}
