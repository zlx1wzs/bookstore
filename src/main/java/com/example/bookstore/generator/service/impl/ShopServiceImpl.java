package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.Shop;
import com.example.bookstore.generator.mapper.ShopMapper;
import com.example.bookstore.generator.service.ShopService;
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
 * 商店 服务层实现类
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Autowired
    HttpServletRequest request;
    @Override
    public Boolean add(Shop shop) throws AgainLoginException {
        shop.setCreateTime(DateTool.getCurrTime());
        if(shop.getUserId()==null){
            String token = request.getHeader("token");
            String userId = JwtUtil.validateToken(token);
            shop.setUserId(userId);
        }
        this.save(shop);
        return true;
    }

    @Override
    public Boolean update(Shop shop) {
        this.updateById(shop);
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
            Shop shop = new Shop();

            //修改的条件
            UpdateWrapper<Shop> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);

            //执行
            this.update(shop, updateWrapper);
        }
    }

    @Override
    public List<Shop> list(String id) {
        return this.list(id);
    }

    @Override
    public Page<Shop> page(Integer pageNum, Integer pageSize,String shopname) {
        Page<Shop> page = new Page(pageNum, pageSize);

        if(!shopname.isEmpty()) {
            QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("shopname", shopname);
            return this.page(page, queryWrapper);
        }
        else return this.page(page);
    }
}
