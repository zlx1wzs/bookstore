package com.example.bookstore.generator.entity;

import com.example.bookstore.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CartVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "商品图片")
    private String img;

    @ApiModelProperty(value = "库存")
    private Integer inventory;

    @ApiModelProperty(value = "创建时间")
    private String createTimes;

    @ApiModelProperty(value = "商品类别")
    private String category;

    @ApiModelProperty(value = "商品作者")
    private String author;

    @ApiModelProperty(value = "出版商")
    private String publisher;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "商店名")
    private String shopname;

    @ApiModelProperty(value = "商店id")
    private String shopId;

    @ApiModelProperty(value = "单个商品数量")
    private Integer shopnumber;

    @ApiModelProperty(value = "关联商品id")
    private String goodsId;

    @ApiModelProperty(value = "关联使用者id")
    private String userId;

    @ApiModelProperty(value = "选择结算的总价")
    private Double totalprice;

    @ApiModelProperty(value = "选择结算的总数量")
    private Integer totalnumber;

}
