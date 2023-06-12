package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.Roles;
import com.example.bookstore.generator.mapper.RolesMapper;
import com.example.bookstore.generator.service.RolesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务层实现类
 * </p>
 *
 * @author wzs
 * @since 2022-12-29
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements RolesService {


    @Override
    public Boolean add(Roles roles) {
        this.save(roles);
        return true;
    }

    @Override
    public Boolean update(Roles roles) {
        this.updateById(roles);
        return true;
    }

    @Override
    public void deleteByIds(String ids) {
        List
                <String> listIds = new ArrayList<>();
        String[] aryIds = ids.split(",");
        for (String id : aryIds) {
            listIds.add(id);
        }
        this.removeByIds(listIds);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
        //ids 若干个id 用逗号隔开
        String[] aryIds = ids.split(",");
        for (String id : aryIds) {

            //修改的value
            Roles roles = new Roles();


            //修改的条件
            UpdateWrapper<Roles> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);

            //执行
            this.update(roles, updateWrapper);
        }
    }

    @Override
    public List<Roles> list(String id) {
        return this.list(id);
    }

    @Override
    public Page<Roles> page(Integer pageNum, Integer pageSize, String roless) {
        Page<Roles> page = new Page(pageNum, pageSize);

        if (!roless.isEmpty()) {
            QueryWrapper<Roles> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("roless", roless);
            return this.page(page, queryWrapper);
        } else return this.page(page);
    }
}
