package com.example.bookstore.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.generator.entity.Favor;
import com.example.bookstore.generator.entity.FavorVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 收藏 Mapper 接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
public interface FavorMapper extends BaseMapper<Favor> {
    @Select("SELECT c.id,b.name category,a.name,a.price,a.author,a.img,a.publisher,a.description ,e.shopname" +
            " from goods a,category b,favor c ,shop e " +
            "where  a.id=c.goods_id AND b.id=a.category  AND c.user_id=#{userId} AND e.id=a.shop_id")
    List<FavorVO> getFavor(String userId);

    @Select("SELECT * FROM favor where  favor.goods_id=#{goodsId} and user_id=#{userId}")
    List<Favor> getFavors(String userId, String goodsId);

    @Select("SELECT * FROM favor where  favor.goods_id=#{goodsId} and user_id=#{userId}")
    List<FavorVO> getFavorss(String userId, String goodsId);

}
