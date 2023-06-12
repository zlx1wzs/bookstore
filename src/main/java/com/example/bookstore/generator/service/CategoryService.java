package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.generator.entity.Category;

import java.util.List;

/**
 * <p>
 * 服务类接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
public interface CategoryService extends IService<Category> {


    Boolean add(Category category);

    Boolean update(Category category);

    void deleteByIds(String ids);

    void updateUsefulByIds(String ids, Integer useful);

    List<Category> list(String id);

    Page<Category> page(Integer pageNum, Integer pageSize,String name);

    List<Category> getnems(String id);
}