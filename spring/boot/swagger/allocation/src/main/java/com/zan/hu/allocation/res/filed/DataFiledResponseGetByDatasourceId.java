package com.zan.hu.allocation.res.filed;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 10/46
 */
@Data
@ApiModel
public class DataFiledResponseGetByDatasourceId {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("列名")
    private String fieldName;

    @ApiModelProperty("列")
    private String filed;

    @ApiModelProperty("版本")
    private String version;

    @ApiModelProperty("分区属性")
    private String partitionType;

    @ApiModelProperty("状态")
    private Integer status;
}
