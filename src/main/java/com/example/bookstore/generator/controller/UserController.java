package com.example.bookstore.generator.controller;

import com.example.bookstore.generator.entity.User;
import com.example.bookstore.generator.service.UserService;
import com.example.bookstore.utils.JwtUtil;
import com.example.bookstore.utils.Result;
import com.mysql.cj.util.Base64Decoder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
@RequestMapping("/generator/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static Base64Decoder decoder=new Base64Decoder();
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Result login(@RequestBody User user) {
        Result result = new Result();
        try{
            List<User> users = userService.login(user);
            String username = users.get(0).getUsername();
            String token = JwtUtil.generateToken(users.get(0).getId());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            if (encoder.matches(user.getPassword(), users.get(0).getPassword())) { //进行一个数据的校验
                result.success("登陆成功");
                Map<String, Object> map = new HashMap<>();
                map.put("token", token);
                map.put("username", username);
                String log = users.get(0).getLog();
                String[] split = log.split("\"");
                log = "\"" + split[13] + "\"";




                map.put("log", log);
                map.put("sex", users.get(0).getSex());
                result.setData(map);
                return result;
            } else {
                result.fail("密码错误");
            }}catch (Exception e){
            result.fail("用户不存在");
        }
        return result;
    }


    @ApiOperation(value = "保存User信息")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody User user) {
        Result result = new Result();
        //业务 交给业务成 service 去处理
        if (userService.add(user))
            result.success("添加成功");
        else
            result.fail("添加失败");
        return result;
    }

    @ApiOperation(value = "修改User信息")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Result update(@RequestBody User user) {
        Result result = new Result();
        //业务 交给业务成 service 去处理

        userService.update(user);
        result.success("修改成功");
        return result;
    }

    @ApiOperation(value = "批量删除记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, paramType = "query", value = "需要删除的多个id，用逗号,隔开")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds(String ids) {
        Result result = new Result();
        userService.deleteByIds(ids);
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
        userService.updateUsefulByIds(ids, useful);
        result.success("更新成功");
        return result;
    }

    @ApiOperation(value = "查询所有记录")
    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public Result list() {
        Result result = new Result();
        result.success("获取list成功");
        result.setData(userService.list());
        return result;
    }

    @ApiOperation(value = "分页获取记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", required = true, paramType = "query", value = "当前页码"),
            @ApiImplicitParam(name = "pageSize", required = true, paramType = "query", value = "每页记录数")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/page")
    public Result page( Integer pageNum,  Integer pageSize,String username) {
        Result result = new Result();
        result.success("获取list成功");
        result.setData(userService.page(pageNum, pageSize,username));
        return result;
    }
}
