package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Orders;
import com.example.bookstore.generator.entity.OrdersVO;
import com.example.bookstore.utils.AgainLoginException;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2022-12-24
*/
public interface OrdersService extends IService<Orders> {


Boolean add(Orders orders) throws AgainLoginException;
Boolean update(Orders orders);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<OrdersVO> lists() throws AgainLoginException;
    List<OrdersVO> page(Integer pageNum,Integer pageSize,String username);
    Integer toal();
}