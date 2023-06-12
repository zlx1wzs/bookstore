package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.generator.entity.User;

import java.util.List;

/**
 * <p>
 * 服务类接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
public interface UserService extends IService<User> {


    Boolean add(User user);

    Boolean update(User user);

    void deleteByIds(String ids);

    void updateUsefulByIds(String ids, Integer useful);

    List<User> list(String id);

    Page<User> page(Integer pageNum, Integer pageSize,String username);

    List<User> login(User user);


}