package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.Favor;
import com.example.bookstore.generator.entity.FavorVO;
import com.example.bookstore.generator.mapper.FavorMapper;
import com.example.bookstore.generator.service.FavorService;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.DateTool;
import com.example.bookstore.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 收藏 服务层实现类
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@Service
public class FavorServiceImpl extends ServiceImpl<FavorMapper, Favor> implements FavorService {

    @Autowired
    HttpServletRequest request;
    @Override
    public Boolean add(Favor favor) throws AgainLoginException {
        favor.setCreateTime(DateTool.getCurrTime());
        String token = request.getHeader("token");
        String userId = JwtUtil.validateToken(token);
        List<Favor> favor1=baseMapper.getFavors(userId,favor.getGoodsId());
        if(favor1.isEmpty()) {
            favor.setUserId(userId);
            this.save(favor);
            return true;
        }else return false;

    }

    @Override
    public Boolean update(Favor favor) {
        this.updateById(favor);
        return true;
    }

    @Override
    public void delete(String id) {

        this.removeById(id);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
        //ids  若干个id 用逗号隔开
        String[] aryIds = ids.split(",");
        for (String id : aryIds) {

            //修改的value
            Favor favor = new Favor();


            //修改的条件
            UpdateWrapper<Favor> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);

            //执行
            this.update(favor, updateWrapper);
        }
    }

    @Override
    public List<FavorVO> lists(String goodsId) throws AgainLoginException {
        String token = request.getHeader("token");
        String userId = JwtUtil.validateToken(token);
        return goodsId==null?baseMapper.getFavor(userId):baseMapper.getFavorss(userId,goodsId);
    }

    @Override
    public Page<Favor> page(Integer pageNum, Integer pageSize) {
        Page<Favor> page = new Page(pageNum, pageSize);
        return this.page(page);
    }
}
