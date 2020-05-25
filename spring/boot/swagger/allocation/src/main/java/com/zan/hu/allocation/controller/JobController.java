package com.zan.hu.allocation.controller;

import com.google.common.collect.Lists;
import com.zan.hu.allocation.req.JobInstanceRequestList;
import com.zan.hu.allocation.req.JobRequestAdd;
import com.zan.hu.allocation.res.PagingObj;
import com.zan.hu.allocation.res.job.JobResponseList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/25 11/28
 */
@RestController
@RequestMapping("/cf/allocation/job")
@Api("任务")
public class JobController {

    @PostMapping("/add")
    @ApiOperation(value = "新增任务")
    public void add(@RequestBody JobRequestAdd jobRequestAdd) {

    }

    @PostMapping("/executive")
    @ApiOperation(value = "运行任务")
    public void executiveJob(@RequestParam("id") Long id) {

    }

    @PostMapping
    @ApiOperation(value = "任务列表")
    public PagingObj<JobResponseList> list(@RequestBody JobInstanceRequestList jobInstanceRequestList) {
        return new PagingObj<JobResponseList>(40, 1, 20, Lists.newArrayList(new JobResponseList()));
    }

    @GetMapping
    @ApiOperation(value = "任务执行结果")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long", paramType = "query")
    public String getExecutiveResultById(@RequestParam("id") Long id) {
        return "";
    }
}
