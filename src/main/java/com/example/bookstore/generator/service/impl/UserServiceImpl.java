package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.User;
import com.example.bookstore.generator.mapper.UserMapper;
import com.example.bookstore.generator.service.UserService;
import com.example.bookstore.utils.DateTool;
import org.apache.ibatis.annotations.Result;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务层实现类
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private Result result;

    @Override
    public Boolean add(User user) {
        user.setCreateTime(DateTool.getCurrTime());
        user.setId(user.getTelphone());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePasswod = encoder.encode(user.getPassword());
        user.setPassword(encodePasswod);
        if(user.getType()==null)
            user.setType("普通用户");
        if (this.save(user))
            return true;
        else return false;


    }

    @Override
    public Boolean update(User user) {
        if(user.getPassword()!=null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            String encodePasswod = encoder.encode(user.getPassword());
            user.setPassword(encodePasswod);
        }
        if(user.getType()==null)
            user.setType("普通用户");
        this.updateById(user);
        return true;
    }

    @Override
    public void deleteByIds(String ids) {
        List<String> listIds = new ArrayList<>();
        String[] aryIds = ids.split(",");
        for (String id : aryIds) {
            listIds.add(id);
        }
        this.removeByIds(listIds);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
        //ids  若干个id 用逗号隔开
        String[] aryIds = ids.split(",");
        for (String id : aryIds) {

            //修改的value
            User user = new User();
            //修改的条件
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);

            //执行
            this.update(user, updateWrapper);
        }
    }

    @Override
    public List<User> list(String id) {
        return this.list(id);
    }

    @Override
    public Page<User> page(Integer pageNum, Integer pageSize, String username) {
        Page<User> page = new Page(pageNum, pageSize);
        if(!username.isEmpty()) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("username", username);
            return this.page(page, queryWrapper);
        }
        else return this.page(page);
    }

    @Override
    public List<User> login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        return this.list(queryWrapper);
    }
}
