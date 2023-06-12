package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Payment;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2023-05-25
*/
public interface PaymentService extends IService<Payment> {


Boolean add(Payment payment);
Boolean update(Payment payment);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Payment> list(String id);
Page<Payment> page(Integer pageNum,Integer pageSize);
}