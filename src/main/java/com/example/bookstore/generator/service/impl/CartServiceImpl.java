package com.example.bookstore.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.generator.entity.Cart;
import com.example.bookstore.generator.entity.CartVO;
import com.example.bookstore.generator.entity.CartVOshop;
import com.example.bookstore.generator.mapper.CartMapper;
import com.example.bookstore.generator.service.CartService;
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
 * 购物车 服务层实现类
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    HttpServletRequest request;
    @Override
    public Boolean add(Cart cart) throws AgainLoginException {
        cart.setCreateTime(DateTool.getCurrTime());
        cart.setGoodsId(cart.getGoodsId());
        String token = request.getHeader("token");
        String userId = JwtUtil.validateToken(token);
        cart.setUserId(userId);
        Integer flg = 1;
        List<Cart> carts = baseMapper.addCart(cart.getGoodsId(), userId);
        if (carts.isEmpty()) {
            flg = 1;
            cart.setShopnumber(flg);
            this.save(cart);
        } else {
            flg = carts.get(0).getShopnumber() + 1;
            cart.setShopnumber(flg);
            String id = carts.get(0).getId();
            baseMapper.updateShopNumber(flg, id);
        }
        return true;
    }



    @Override
    public Boolean update( Cart cart) {
        this.updateById(cart);
        return true;
    }

    @Override
    public void deleteByIds(String id) {
       baseMapper.deletes(id);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
        //ids  若干个id 用逗号隔开
        String[] aryIds = ids.split(",");
        for (String id : aryIds) {
            //修改的value
            Cart cart = new Cart();
            //修改的条件
            UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id);
            //执行
            this.update(cart, updateWrapper);
        }
    }

    @Override
    public List<Cart> list(String id) {
        return this.list(id);
    }

    @Override
    public Page<Cart> page(Integer pageNum, Integer pageSize) {
        Page<Cart> page = new Page(pageNum, pageSize);
        return this.page(page);
    }

    @Override
    public List<List> getCart(String username) {
        if (baseMapper.goods(username) != null) {
            List<CartVOshop> shop = baseMapper.shopId(username);
            List<CartVO> cart = baseMapper.goods(username);
            List<List> person = new ArrayList<>(cart.size());
            for (CartVOshop carts : shop) {
                //直接从Map中查找
                List<CartVO> persons = new ArrayList<>(cart.size());
                for (CartVO c : cart) {
                    if (c.getShopId().equals(carts.getShopId())) {
                        persons.add(c);
                    }
                }
                person.add(persons);
            }
            return person;
        } else return null;
    }
    @Override
    public List<CartVO> getCarts(String username) {
        if (baseMapper.goods(username) != null) {
            List<CartVO> cart = baseMapper.goods(username);
            return cart;
        }
        return null;
    }
}
