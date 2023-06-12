package com.example.bookstore.generator.controller;

import com.example.bookstore.generator.entity.Cart;
import com.example.bookstore.generator.service.CartService;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@CrossOrigin
@RestController
@RequestMapping("/generator/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @ApiOperation(value = "保存Cart信息")
    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public Result save(@RequestBody Cart cart) throws AgainLoginException {
        Result result = new Result();
        //业务 交给业务成 service 去处
        cartService.add(cart);
        result.success("保存成功");
        return result;
    }

    @ApiOperation(value = "修改Cart信息")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Result update(@RequestBody Cart cart) {
        Result result = new Result();
        //业务 交给业务成 service 去处理
        cartService.update(cart);
        result.success("修改成功");
        return result;
    }

    @ApiOperation(value = "批量删除记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, paramType = "query", value = "需要删除的多个id，用逗号,隔开")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds( String id) {
        Result result = new Result();
        cartService.deleteByIds(id );
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
        cartService.updateUsefulByIds(ids, useful);
        result.success("更新成功");
        return result;
    }

    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public Result list(String username) {
        Result result = new Result();
        List<List> c = cartService.getCart(username);
        result.setData(c);
        return result;
    }

    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST, value = "/lists")
    public Result lists(String username) {
        Result result = new Result();

        result.setData(cartService.getCarts(username));
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
        result.setData(cartService.page(pageNum, pageSize));
        return result;
    }
}
