package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.generator.entity.Cart;
import com.example.bookstore.utils.AgainLoginException;

import java.util.List;

/**
 * <p>
 * 购物车 服务类接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
public interface CartService extends IService<Cart> {


    Boolean add(Cart cart) throws AgainLoginException;

    Boolean update(Cart cart);
    void deleteByIds(String ids);

    void updateUsefulByIds(String ids, Integer useful);

    List<Cart> list(String id);

    Page<Cart> page(Integer pageNum, Integer pageSize);

    List<List> getCart(String username);

    Object getCarts(String username);
}