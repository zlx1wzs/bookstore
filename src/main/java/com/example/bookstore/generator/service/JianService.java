package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Jian;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2023-05-25
*/
public interface JianService extends IService<Jian> {


Boolean add(Jian jian);
Boolean update(Jian jian);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Jian> list(String id);
Page<Jian> page(Integer pageNum,Integer pageSize);
}