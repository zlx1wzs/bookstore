package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.Goods;
import com.example.bookstore.generator.entity.GoodsBriefVO;
import com.example.bookstore.generator.mapper.GoodsMapper;
import com.example.bookstore.generator.service.GoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {


    @Override
    public Boolean add(Goods goods) {
        goods.setCreateTime(DateTool.getCurrTime());

        this.save(goods);
        return true;
    }

    @Override
    public Boolean update(Goods goods) {
        this.updateById(goods);
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
    public void updateUsefulByIds(String Ids) {
        //ids  若干个id 用逗号隔开
        String[] aryIds = Ids.split(",");
        for (String id : aryIds) {
            //修改的value
            Goods goods = new Goods();
            //修改的条件
            UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);
            //执行
            this.update(goods, updateWrapper);
        }
    }


    @Override
    public Page<Goods> page(Integer pageNum, Integer pageSize,String name) {
        Page<Goods> page = new Page(pageNum, pageSize);
        if(!name.isEmpty()) {
            QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name", name);
            return this.page(page, queryWrapper);
        }
        else return this.page(page);
    }

    @Override
    public List<Goods> getcategory(String category) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("category", category);
        return this.list(queryWrapper);
    }

    @Override
    public List<GoodsBriefVO> lists(Goods goods) {
        return goods.getCategory()==null ? baseMapper.listAll() : baseMapper.listCateory(goods.getCategory());
    }
}
