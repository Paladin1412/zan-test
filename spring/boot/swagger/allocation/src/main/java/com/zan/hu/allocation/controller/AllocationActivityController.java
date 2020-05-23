package com.zan.hu.allocation.controller;

import com.google.common.collect.Lists;
import com.zan.hu.allocation.req.AllocationActivityRequestAdd;
import com.zan.hu.allocation.req.AllocationActivityRequestList;
import com.zan.hu.allocation.res.PagingObj;
import com.zan.hu.allocation.res.allocationactivity.AllocationActivityResponseGetById;
import com.zan.hu.allocation.res.allocationactivity.AllocationActivityResponseList;
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
 * @Date 2020-05-23 15:41
 * @Description
 **/
@RestController
@RequestMapping("/cf/finance/allocation/activity")
@Api("分摊活动")
public class AllocationActivityController {

    @PostMapping
    @ApiOperation(value = "分摊活动列表")
    public PagingObj<AllocationActivityResponseList> list(@RequestBody AllocationActivityRequestList allocationActivityRequestList) {
        return new PagingObj(40, 1, 20, Lists.newArrayList(new AllocationActivityResponseList()));
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增分摊活动")
    public void add(@RequestBody AllocationActivityRequestAdd allocationActivityRequestAdd) {
    }


    @PutMapping
    @ApiOperation(value = "编辑分摊活动")
    public void edit(AllocationActivityRequestAdd allocationActivityRequestAdd) {
    }

    @GetMapping
    @ApiOperation(value = "查看分摊活动")
    public AllocationActivityResponseGetById getById(@RequestParam("id") Long id) {
        return new AllocationActivityResponseGetById();
    }

    @GetMapping("/check/filed")
    @ApiOperation(value = "check该分摊活动名称or分摊活动code是否重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "allocationActivityName", value = "分摊活动名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "allocationActivityCode", value = "分摊活动code", required = false, dataType = "String", paramType = "query"),

    })
    public boolean checkFiledRepeat(@RequestParam(value = "allocationActivityName", required = false) String allocationActivityName,
                                    @RequestParam(value = "allocationActivityCode", required = false) String allocationActivityCode) {
        return false;
    }
}
