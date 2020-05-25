package com.zan.hu.allocation.res.datasource;

import com.zan.hu.allocation.req.DataSourceRequestAddOrEdit;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 15:05
 * @Description
 **/
@Data
public class FiDataSourceResponseGetById extends FiDataSourceResponse {

    @ApiModelProperty("状态")
    int status;

    @ApiModelProperty("摘要")
    String summary;

    @ApiModelProperty("筛选字段")
    String filterCondition;


    @ApiModelProperty("行字段")
    List<DataSourceRequestAddOrEdit.LineField> lineFields;
}
