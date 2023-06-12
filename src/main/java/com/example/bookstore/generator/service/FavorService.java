package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.generator.entity.Favor;
import com.example.bookstore.generator.entity.FavorVO;
import com.example.bookstore.utils.AgainLoginException;

import java.util.List;

/**
 * <p>
 * 收藏 服务类接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
public interface FavorService extends IService<Favor> {


    Boolean add(Favor favor) throws AgainLoginException;

    Boolean update(Favor favor);

    void delete(String id);

    void updateUsefulByIds(String ids, Integer useful);

    List<FavorVO> lists(String goodsId) throws AgainLoginException;

    Page<Favor> page(Integer pageNum, Integer pageSize);
}