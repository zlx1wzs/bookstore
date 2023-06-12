package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.OrdersVO;
import com.example.bookstore.generator.mapper.OrdersMapper;
import com.example.bookstore.generator.entity.Orders;
import com.example.bookstore.generator.service.OrdersService;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.DateTool;
import com.example.bookstore.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author wzs
* @since 2022-12-24
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper,Orders> implements OrdersService {

    @Autowired
    HttpServletRequest request;
@Override
public Boolean add(Orders orders) throws AgainLoginException {
orders.setCreateTime(DateTool.getCurrTime());
    String token = request.getHeader("token");
    String userId = JwtUtil.validateToken(token);
    orders.setUserId(userId);
this.save(orders);
return true;
}

@Override
public Boolean update(Orders orders) {
this.updateById(orders);
return true;
}

@Override
public void deleteByIds(String ids) {
List<String> listIds = new ArrayList<>();
    String[] aryIds = ids.split(",");
    for(String id: aryIds){
    listIds.add(id);
    }
    this.removeByIds(listIds);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
    //ids 若干个id 用逗号隔开
    String[] aryIds = ids.split(",");
    for(String id: aryIds){

    //修改的value
    Orders orders = new Orders();


    //修改的条件
    UpdateWrapper<Orders> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(orders,updateWrapper);
    }
    }

    @Override
    public List<OrdersVO> lists() throws AgainLoginException {
        String token = request.getHeader("token");
        String userId = JwtUtil.validateToken(token);
    return baseMapper.getOder(userId);
    }

    @Override
    public List<OrdersVO> page(Integer pageNum,Integer pageSize,String username) {

        if(!username.isEmpty()) {

            return baseMapper.getOderss(pageNum,pageSize,username);
        }
        else return baseMapper.getOders(pageNum,pageSize);
        }
    @Override
    public Integer toal(){
       return baseMapper.all().size();
    }
    }
