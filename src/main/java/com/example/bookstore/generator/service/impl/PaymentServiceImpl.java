package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.mapper.PaymentMapper;
import com.example.bookstore.generator.entity.Payment;
import com.example.bookstore.generator.service.PaymentService;
import com.example.bookstore.utils.DateTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author wzs
* @since 2023-05-25
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper,Payment> implements PaymentService {


@Override
public Boolean add(Payment payment) {
payment.setCreateTime(DateTool.getCurrTime());

this.save(payment);
return true;
}

@Override
public Boolean update(Payment payment) {
    System.out.println(payment.getTime()+"kkkkkkkk");
this.updateById(payment);
return true;
}

@Override
public void deleteByIds(String ids) {
List
<String> listIds = new ArrayList<>();
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
    Payment payment = new Payment();


    //修改的条件
    UpdateWrapper<Payment> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(payment,updateWrapper);
    }
    }

    @Override
    public List<Payment> list(String id ) {
    return this.list(id);
    }

    @Override
    public Page<Payment> page(Integer pageNum,Integer pageSize) {
    Page<Payment> page = new Page(pageNum,pageSize);
    return this.page(page);
    }
    }
