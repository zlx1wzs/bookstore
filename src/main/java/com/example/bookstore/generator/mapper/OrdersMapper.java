package com.example.bookstore.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.generator.entity.Orders;
import com.example.bookstore.generator.entity.OrdersVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wzs
 * @since 2022-12-24
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    @Select("SELECT a.id,a.name,a.price,a.author,a.img,a.publisher,a.description, b.name category ,c.shopname, d.status" +
            " from goods a, category b,shop c, orders d" +
            " where a.category = b.id and c.id=a.shop_id and d.user_id=#{userId} and a.id=d.goods_id")
    List<OrdersVO> getOder(String userId);

    @Select("SELECT  a.id,a.cancle_reason,a.refund,a.refund_admin,a.status,a.shopnumber,a.totalprice,b.name ,c.username,d.address " +
            "from addr d, orders a,goods b,user c " +
            "WHERE b.id=a.goods_id and c.id=a.user_id and d.ordersid=a.id LIMIT #{pageNum},#{pageSize}")
    List<OrdersVO> getOders(Integer pageNum, Integer pageSize);

    @Select("SELECT  a.id,a.cancle_reason,a.refund,a.refund_admin,a.status,a.shopnumber,a.totalprice,b.name ,c.username,d.address " +
            "from addr d, orders a,goods b,user c " +
            "WHERE b.id=a.goods_id and c.id=a.user_id and d.ordersid=a.id LIMIT #{pageNum},#{pageSize}")
    List<OrdersVO> getOderss(Integer pageNum, Integer pageSize, String username);

    @Select("SELECT  a.id,a.cancle_reason,a.refund,a.refund_admin,a.status,a.shopnumber,a.totalprice,b.name ,c.username,d.address" +
            " from addr d, orders a,goods b,user c " +
            "WHERE b.id=a.goods_id and c.id=a.user_id and d.ordersid=a.id")
    List<OrdersVO> all();

}
