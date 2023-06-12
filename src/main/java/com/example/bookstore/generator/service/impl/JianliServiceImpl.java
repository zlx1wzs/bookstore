package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.mapper.JianliMapper;
import com.example.bookstore.generator.entity.Jianli;
import com.example.bookstore.generator.service.JianliService;
import com.example.bookstore.utils.DateTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author wzs
* @since 2023-05-25
*/
@Service
public class JianliServiceImpl extends ServiceImpl<JianliMapper,Jianli> implements JianliService {


@Override
public Boolean add(Jianli jianli) {
jianli.setCreateTime(DateTool.getCurrTime());

this.save(jianli);
return true;
}

@Override
public Boolean update(Jianli jianli) {
this.updateById(jianli);
return true;
}

@Override
public void deleteByIds(String ids) {
List
<String> listIds = new ArrayList<>();
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
    Jianli jianli = new Jianli();


    //修改的条件
    UpdateWrapper<Jianli> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(jianli,updateWrapper);
    }
    }

    @Override
    public List<Jianli> list(String id ) {
    return this.list(id);
    }

    @Override
    public Page<Jianli> page(Integer pageNum,Integer pageSize) {
    Page<Jianli> page = new Page(pageNum,pageSize);
    return this.page(page);
    }
    }
