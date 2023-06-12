package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Message;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2023-05-26
*/
public interface MessageService extends IService<Message> {


Boolean add(Message message);
Boolean update(Message message);
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Message> list(String id);
Page<Message> page(Integer pageNum,Integer pageSize);
}