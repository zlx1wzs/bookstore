package com.example.bookstore.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.generator.entity.Job;
import com.example.bookstore.utils.AgainLoginException;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author wzs
* @since 2023-05-24
*/
public interface JobService extends IService<Job> {


Boolean add(Job job) throws AgainLoginException;
Boolean update(Job job);

    List<Job> upnow(String id);

    void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<Job> lists(String id);

List<Job>getjob(String id);

Page<Job> page(Integer pageNum, Integer pageSize);

    List<Job> now();
}