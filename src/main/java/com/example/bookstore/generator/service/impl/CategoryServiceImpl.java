package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.Category;
import com.example.bookstore.generator.mapper.CategoryMapper;
import com.example.bookstore.generator.service.CategoryService;
import com.example.bookstore.utils.DateTool;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Override
    public Boolean add(Category category) {
        category.setCreateTime(DateTool.getCurrTime());

        this.save(category);
        return true;
    }

    @Override
    public Boolean update(Category category) {
        this.updateById(category);
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
            Category category = new Category();


            //修改的条件
            UpdateWrapper<Category> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);

            //执行
            this.update(category, updateWrapper);
        }
    }

    @Override
    public List<Category> list(String id) {
        return this.list(id);
    }

    @Override
    public Page<Category> page(Integer pageNum, Integer pageSize,String name) {
        Page<Category> page = new Page(pageNum, pageSize);
        if(!name.isEmpty()) {
            QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name", name);
            return this.page(page, queryWrapper);
        }
        else return this.page(page);
    }

    @Override
    public List<Category> getnems(String id) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        this.list(queryWrapper).get(0).getName();
        return this.list(queryWrapper);
    }

}
