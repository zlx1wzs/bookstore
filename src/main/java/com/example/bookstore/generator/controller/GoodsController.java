package com.example.bookstore.generator.controller;

import com.example.bookstore.generator.entity.Goods;
import com.example.bookstore.generator.service.GoodsService;
import com.example.bookstore.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
@CrossOrigin
@RestController
@RequestMapping("/generator/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;


    @ApiOperation(value = "保存Goods信息")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save( Goods goods) {
        Result result = new Result();
        //业务 交给业务成 service 去处理
        //System.out.println(goods);
        goodsService.add(goods);

        result.success("保存成功");
        return result;
    }

    @ApiOperation(value = "修改Goods信息")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Result update(@RequestBody Goods goods) {
        Result result = new Result();
        //业务 交给业务成 service 去处理
        goodsService.update(goods);
        result.success("修改成功");
        return result;
    }

    @ApiOperation(value = "批量删除记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, paramType = "query", value = "需要删除的多个id，用逗号,隔开")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds(@RequestBody String ids) {
       // System.out.println(ids);
        Result result = new Result();
        goodsService.deleteByIds(ids);
        result.success("删除成功");
        return result;
    }

    @ApiOperation(value = "批量更新记录的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, paramType = "query", value = "需要更新的多个id，用逗号,隔开"),
            @ApiImplicitParam(name = "useful", required = true, paramType = "query", value = "是否有用，0-不可用 1-可用")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/updateUsefulByIds")
    public Result updateUsefulByIds(String categorys) {
        Result result = new Result();
        goodsService.updateUsefulByIds(categorys);
        result.success("更新成功");
        return result;
    }

    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public Result list(@RequestBody Goods goods) {
//        System.out.println(goods);
        Result result = new Result();
        result.setData(goodsService.lists(goods));
        return result;
    }

    @ApiOperation(value = "分页获取记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", required = true, paramType = "query", value = "当前页码"),
            @ApiImplicitParam(name = "pageSize", required = true, paramType = "query", value = "每页记录数")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/page")
    public Result page(Integer pageNum, Integer pageSize,String name) {
        Result result = new Result();
        result.success("获取list成功");
        result.setData(goodsService.page(pageNum, pageSize,name));
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public Result category(String category) {
        Result result = new Result();
        result.success("获取category成功");
        result.setData(goodsService.getcategory(category));
        return result;
    }
}
