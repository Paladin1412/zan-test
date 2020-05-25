package com.zan.hu.allocation.controller;

import com.zan.hu.allocation.res.filed.DataFiledResponseGetByDatasourceId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 10/41
 */
@RestController
@RequestMapping("/cf/allocation/data/filed")
@Api("分摊数据列")
public class DataFiledController {

    @GetMapping
    @ApiOperation(value = "查询分摊字段")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "datasourceId", value = "数据源ID", required = true, dataType = "Long",
            paramType = "query"),
    })
    public DataFiledResponseGetByDatasourceId getByDatasourceId(@RequestParam("datasourceId") Long datasourceId) {
        return new DataFiledResponseGetByDatasourceId();
    }
}
