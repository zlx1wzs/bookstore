package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.generator.entity.Shop;
import com.example.bookstore.utils.AgainLoginException;

import java.util.List;

/**
 * <p>
 * 商店 服务类接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
public interface ShopService extends IService<Shop> {


    Boolean add(Shop shop) throws AgainLoginException;

    Boolean update(Shop shop);

    void deleteByIds(String ids);

    void updateUsefulByIds(String ids, Integer useful);

    List<Shop> list(String id);

    Page<Shop> page(Integer pageNum, Integer pageSize,String shopname);
}