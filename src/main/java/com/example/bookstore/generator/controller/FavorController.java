package com.example.bookstore.generator.controller;

import com.example.bookstore.generator.entity.Favor;
import com.example.bookstore.generator.service.FavorService;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 收藏 前端控制器
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@CrossOrigin
@RestController
@RequestMapping("/generator/favor")
public class FavorController {
    @Autowired
    private FavorService favorService;

    @ApiOperation(value = "保存Favor信息")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody Favor favor) throws AgainLoginException {
        Result result = new Result();
        //业务 交给业务成 service 去处
        if(favorService.add(favor))
          result.success("已收藏");
        else result.success("已收藏");
        return result;
    }

    @ApiOperation(value = "修改Favor信息")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Result update(@RequestBody Favor favor)  throws AgainLoginException {
        Result result = new Result();
        //业务 交给业务成 service 去处理
        favorService.update(favor);
        result.success("修改成功");
        return result;
    }

    @ApiOperation(value = "批量删除记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, paramType = "query", value = "需要删除的多个id，用逗号,隔开")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteById(String id) {
        Result result = new Result();
        favorService.delete(id);
        result.success("删除成功");
        return result;
    }

    @ApiOperation(value = "批量更新记录的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, paramType = "query", value = "需要更新的多个id，用逗号,隔开"),
            @ApiImplicitParam(name = "useful", required = true, paramType = "query", value = "是否有用，0-不可用 1-可用")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/updateUsefulByIds")
    public Result updateUsefulByIds(String ids, Integer useful) {
        Result result = new Result();
        favorService.updateUsefulByIds(ids, useful);
        result.success("更新成功");
        return result;
    }

    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public Result list(String goodsId) throws AgainLoginException {
        Result result = new Result();
        result.success("获取list成功");
        result.setData(favorService.lists(goodsId));
        return result;
    }

    @ApiOperation(value = "分页获取记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", required = true, paramType = "query", value = "当前页码"),
            @ApiImplicitParam(name = "pageSize", required = true, paramType = "query", value = "每页记录数")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/page")
    public Result page(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        result.success("获取list成功");
        result.setData(favorService.page(pageNum, pageSize));
        return result;
    }
}
