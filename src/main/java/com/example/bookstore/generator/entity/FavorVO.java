package com.example.bookstore.generator.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FavorVO extends Favor{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "商品图片")
    private String img;

    @ApiModelProperty(value = "库存")
    private Integer inventory;

    @ApiModelProperty(value = "关联商店id")
    private String shopId;

    @ApiModelProperty(value = "商品类别")
    private String category;

    @ApiModelProperty(value = "商品作者")
    private String author;

    @ApiModelProperty(value = "出版商")
    private String publisher;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "商店名称")
    private String shopname;

}
