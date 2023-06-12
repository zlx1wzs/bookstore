package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Roles;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2022-12-29
*/
public interface RolesService extends IService<Roles> {


Boolean add(Roles roles);
Boolean update(Roles roles);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Roles> list(String id);
Page<Roles> page(Integer pageNum,Integer pageSize,String roless);
}