package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.mapper.MessageMapper;
import com.example.bookstore.generator.entity.Message;
import com.example.bookstore.generator.service.MessageService;
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
* @since 2023-05-26
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper,Message> implements MessageService {


@Override
public Boolean add(Message message) {
message.setCreateTime(DateTool.getCurrTime());

this.save(message);
return true;
}

@Override
public Boolean update(Message message) {
this.updateById(message);
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
    Message message = new Message();


    //修改的条件
    UpdateWrapper<Message> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(message,updateWrapper);
    }
    }

    @Override
    public List<Message> list(String id ) {
    return this.list(id);
    }

    @Override
    public Page<Message> page(Integer pageNum,Integer pageSize) {
    Page<Message> page = new Page(pageNum,pageSize);
    return this.page(page);
    }
    }
