package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Coupon;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2023-06-09
*/
public interface CouponService extends IService<Coupon> {


Boolean add(Coupon coupon);
Boolean update(Coupon coupon);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Coupon> list(String id);
Page<Coupon> page(Integer pageNum,Integer pageSize);
}