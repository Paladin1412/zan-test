package com.zan.hu.allocation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zan.hu.allocation.req.DataSourceRequestAddOrEdit;
import com.zan.hu.allocation.req.DataSourceRequestList;
import com.zan.hu.allocation.res.PagingObj;
import com.zan.hu.allocation.res.datasource.FiDataSourceResponseGetById;
import com.zan.hu.allocation.res.datasource.FiDataSourceResponseList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-23 13:53
 * @Description
 **/
@RestController
@RequestMapping("/cf/allocation/datasource")
@Api("数据源管理")
public class DataSourceController {

    @PostMapping
    @ApiOperation(value = "数据源列表")
    public PagingObj<FiDataSourceResponseList> list(@RequestBody DataSourceRequestList dataSourceRequest) {
        List<FiDataSourceResponseList> dataSourceRes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            FiDataSourceResponseList dataSource = new FiDataSourceResponseList();
            dataSource.setName("菜鸟财务域凭证行明细" + i);
            dataSource.setTableName("data_source" + i);
            dataSource.setSource(1);
            dataSource.setDatabaseType("odps数据库");
            dataSource.setStatus(1);
            dataSource.setGmtCreate(new Date());
            dataSource.setCreator("188" + i + "xiaoxi");
            dataSourceRes.add(dataSource);
        }
        return new PagingObj(40, 1, 20, dataSourceRes);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增数据源")
    public void add(@RequestBody DataSourceRequestAddOrEdit dataSourceRequestAddOrEdit) {

    }

    @PutMapping
    @ApiOperation(value = "编辑数据源")
    public void edit(@RequestBody DataSourceRequestAddOrEdit dataSourceRequestAddOrEdit) {

    }

    @GetMapping
    @ApiOperation(value = "查询数据源")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long", paramType = "query"),
    })
    public FiDataSourceResponseGetById getById(@RequestParam("id") Long id) {
        return new FiDataSourceResponseGetById();
    }

    // TODO: 2020-05-25  根据数据源查询分摊字段

    @GetMapping("/check/line/filed")
    @ApiOperation(value = "check该数据源的行字段是否应用分摊规则")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long", paramType = "query"),
    })
    public boolean checkLineFiled(@RequestParam("id") Long id) {
        return true;
    }

    @GetMapping("/check/filed")
    @ApiOperation(value = "check该数据源名称是否重复")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "datasourceName", value = "数据源名称", required = false, dataType = "String",
            paramType = "query"),
    })
    public boolean checkFiledRepeat(@RequestParam(value = "datasourceName", required = false) String datasourceName) {
        return false;
    }

    // TODO: 2020-05-25 查询任务
    // TODO: 2020-05-25 提交新任务 
    // TODO: 2020-05-25 查看执行结果

}
