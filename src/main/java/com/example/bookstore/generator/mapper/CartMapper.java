package com.example.bookstore.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.generator.entity.Cart;
import com.example.bookstore.generator.entity.CartVO;
import com.example.bookstore.generator.entity.CartVOshop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
public interface CartMapper extends BaseMapper<Cart> {

    @Select("SELECT b.name category,a.name,a.price,a.author,a.img,a.publisher,a.description,c.goods_id,c.id," +
            "c.user_id,c.shopnumber,e.shopname,e.id shop_id" +
            " from goods a,category b,cart c ,user d ,shop e" +
            " where  a.id=c.goods_id AND b.id=a.category AND d.username=#{username} AND d.id=c.user_id AND e.id=a.shop_id")
    List<CartVO> goods(@Param("username") String username);

    @Select("SELECT a.* FROM cart a WHERE goods_id=#{goodsId} and user_id=#{userId}")
    List<Cart> addCart(String goodsId, String userId);

    @Select("UPDATE cart SET shopnumber=#{shopnumber} WHERE id=#{id}")
    void updateShopNumber(Integer shopnumber, String id);

    @Select("SELECT a.id shopId,a.shopname FROM shop a,goods b,cart c,user d WHERE" +
            " d.username=#{username} and c.user_id=d.id  and b.id=c.goods_id and a.id=b.shop_id group by a.shopname")
    List<CartVOshop> shopId(String username);

    @Select("delete from cart where cart.id=#{ids}")
    void deletes(String ids);
}
