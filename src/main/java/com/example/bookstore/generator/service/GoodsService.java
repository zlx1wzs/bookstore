package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.generator.entity.Goods;
import com.example.bookstore.generator.entity.GoodsBriefVO;

import java.util.List;

/**
 * <p>
 * 服务类接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
public interface GoodsService extends IService<Goods> {


    Boolean add(Goods goods);

    Boolean update(Goods goods);

    void deleteByIds(String ids);

    void updateUsefulByIds(String categorys);

    Page<Goods> page(Integer pageNum, Integer pageSize,String name);

    List<Goods> getcategory(String category);

    List<GoodsBriefVO> lists(Goods goods);
}