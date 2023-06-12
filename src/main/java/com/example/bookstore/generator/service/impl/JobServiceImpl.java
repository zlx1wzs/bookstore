package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.mapper.JobMapper;
import com.example.bookstore.generator.entity.Job;
import com.example.bookstore.generator.service.JobService;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.DateTool;
import com.example.bookstore.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author wzs
* @since 2023-05-24
*/
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper,Job> implements JobService {

    @Autowired
    HttpServletRequest request;
@Override
public Boolean add(Job job) throws AgainLoginException {
job.setCreateTime(DateTool.getCurrTime());
job.setNow("1");
    String token = request.getHeader("token");
    String userId = JwtUtil.validateToken(token);
    job.setUserid(userId);
this.save(job);
return true;
}

@Override
public Boolean update(Job job) {
    System.out.println(job.getState());
this.updateById(job);
return true;
}
    @Override
    public  List<Job> upnow(String id) {
        System.out.println(id);
        return baseMapper.upnow(id);
    }

@Override
public void deleteByIds(String ids) {
    List<String> listIds = new ArrayList<>();
    String[] aryIds = ids.split(",");
    for(String id: aryIds){
    listIds.add(id);
    }
    this.removeByIds(listIds);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
    //ids 若干个id 用逗号隔开
    String[] aryIds = ids.split(",");
    for(String id: aryIds){

    //修改的value
    Job job = new Job();

    //修改的条件
    UpdateWrapper<Job> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(job,updateWrapper);
    }
    }

    @Override
    public List<Job> lists(String id ) {
    return this.lists(id);
    }
    @Override
    public List<Job>getjob(String id) {

        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("id", id);
        return this.list(queryWrapper);
    }
    @Override
    public Page<Job> page(Integer pageNum,Integer pageSize) {
        Page<Job> page = new Page(pageNum, pageSize);
        return this.page(page);
    }
    @Override
    public List<Job> now() {

        return baseMapper.now();
    }
    }
