package com.zan.hu.allocation.req;

import com.zan.hu.allocation.PagePara;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 13:54
 * @Description
 **/
@Data
@ApiModel("数据源新增or编辑")
// TODO: 2020-05-25 mingcheng
public class DataSourceRequestAddOrEdit extends PagePara {

    @ApiModelProperty("主键")
    private Long Id;

    @ApiModelProperty("数据源名称")
    String name;

    @ApiModelProperty("表名")
    String tableName;

    @ApiModelProperty("数据库类型")
    String databaseType;

    @ApiModelProperty("摘要")
    String summary;

    @ApiModelProperty("筛选字段")
    // TODO: 2020-05-25  duixiang
        String filterCondition;

    @ApiModelProperty("行字段")
    List<LineField> lineFields;

    @Data
    public static class LineField {
        /**
         * 字段名称
         */
        String fieldName;
        /**
         * 字段描述
         */
        String describe;
        /**
         * 字段类型
         * 整型、长整型、浮点型、字符串
         */
        String type;
        /**
         * 是否来源扩展字段：
         * 是、否
         */
        boolean extensionField;
        /**
         * 扩展字段名称
         */
        String extensionFieldName;
        /**
         * 分区字段
         * 非分区字段、分区日字段、分区月字段
         */
        String partitionField;
    }
}
