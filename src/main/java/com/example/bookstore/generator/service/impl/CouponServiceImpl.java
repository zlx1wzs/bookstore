package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.mapper.CouponMapper;
import com.example.bookstore.generator.entity.Coupon;
import com.example.bookstore.generator.service.CouponService;
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
* @since 2023-06-09
*/
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper,Coupon> implements CouponService {


@Override
public Boolean add(Coupon coupon) {
coupon.setCreateTime(DateTool.getCurrTime());

this.save(coupon);
return true;
}

@Override
public Boolean update(Coupon coupon) {
this.updateById(coupon);
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
    Coupon coupon = new Coupon();


    //修改的条件
    UpdateWrapper<Coupon> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(coupon,updateWrapper);
    }
    }

    @Override
    public List<Coupon> list(String id ) {
    return this.list(id);
    }

    @Override
    public Page<Coupon> page(Integer pageNum,Integer pageSize) {
    Page<Coupon> page = new Page(pageNum,pageSize);
    return this.page(page);
    }
    }
