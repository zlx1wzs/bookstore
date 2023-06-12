package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Jianli;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2023-05-25
*/
public interface JianliService extends IService<Jianli> {


Boolean add(Jianli jianli);
Boolean update(Jianli jianli);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Jianli> list(String id);
Page<Jianli> page(Integer pageNum,Integer pageSize);
}