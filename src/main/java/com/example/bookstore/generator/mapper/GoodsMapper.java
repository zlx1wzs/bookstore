package com.example.bookstore.generator.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.generator.entity.Goods;
import com.example.bookstore.generator.entity.GoodsBriefVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select({"SELECT a.id,a.name,a.price,a.author,a.img,a.publisher,a.description," +
            " b.name category ,c.shopname from goods a, category b ,shop c where a.category = b.id and c.id=a.shop_id"})
    List<GoodsBriefVO> listAll();

    @Select({"SELECT a.id,a.name,a.price,a.author,a.img,a.publisher,a.description," +
            " b.name category,c.shopname from goods a,category b,shop c where b.id= a.category and a.category=#{value} and c.id=a.shop_id"})
    List<GoodsBriefVO> listCateory(String id);
}
