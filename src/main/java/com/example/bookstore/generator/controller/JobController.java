package com.example.bookstore.generator.controller;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import com.example.bookstore.generator.entity.Job;
import com.example.bookstore.generator.service.JobService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* <p>
    *  前端控制器
    * </p>
*
* @author wzs
* @since 2023-05-24
*/
    @CrossOrigin
    @RestController
@RequestMapping("/generator/job")
    public class JobController {
    @Autowired
    private JobService jobService;

        @ApiOperation(value = "保存Job信息")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody Job job) throws AgainLoginException {
    Result result = new Result();
    //业务 交给业务成 service 去处理
    jobService.add(job);
    result.success("保存成功");
    return result;
    }

        @ApiOperation(value = "修改Job信息")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Result update(@RequestBody Job job) {
    Result result = new Result();
    //业务 交给业务成 service 去处理

    jobService.update(job);
    result.success("修改成功");
    return result;
    }

        @ApiOperation(value = "批量删除记录")
        @ApiImplicitParams({
        @ApiImplicitParam(name = "ids",required = true,paramType = "query",value = "需要删除的多个id，用逗号,隔开")
        })
    @RequestMapping(method = RequestMethod.POST,value = "/deleteByIds")
    public Result deleteByIds(String ids) {
    Result result = new Result();
    jobService.deleteByIds(ids);
    result.success("删除成功");
    return result;
    }

        @ApiOperation(value = "批量更新记录的状态")
        @ApiImplicitParams({
        @ApiImplicitParam(name = "ids",required = true,paramType = "query",value = "需要更新的多个id，用逗号,隔开"),
        @ApiImplicitParam(name = "useful",required = true,paramType = "query",value = "是否有用，0-不可用 1-可用")
        })
    @RequestMapping(method = RequestMethod.POST,value = "/updateUsefulByIds")
    public Result updateUsefulByIds(String ids,Integer useful) {
    Result result = new Result();
    jobService.updateUsefulByIds(ids,useful);
    result.success("更新成功");
    return result;
    }
    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST,value = "/list")
    public Result list() throws ParseException {
    Result result = new Result();
    result.success("获取list成功");
        Date date=new Date();
        List<Job> job;
        Job j=new Job();
        job=jobService.list();
        int i=0;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for(Job id:job){
            Date   s = sdf.parse(job.get(i).getCreateTime());
            long ds=date.getTime()-s.getTime();
            if(ds>=86400000)
            {
                jobService.upnow(job.get(i).getId());
            }
            i++;
            if(jobService.list().get(i-1).getNow().equals("1"));

        }



    result.setData(jobService.list());
    return result;
    }

        @ApiOperation(value = "分页获取记录")
        @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",required = true,paramType = "query",value = "当前页码"),
        @ApiImplicitParam(name = "pageSize",required = true,paramType = "query",value = "每页记录数")
        })
    @RequestMapping(method = RequestMethod.POST,value = "/page")
    public Result page( Integer pageNum,Integer pageSize ){
    Result result = new Result();
    result.success("获取list成功");
    result.setData(jobService.page(pageNum,pageSize));
    return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/id")
    public Result id(@RequestBody String id) {
        Result result = new Result();
        result.success("获取category成功");
        result.setData(jobService.getjob(id));
        return result;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/getnow")
    public Result getnow(){
        Result result = new Result();
        result.success("获取category成功");
        result.setData(jobService.now());
        return result;
    }
}

