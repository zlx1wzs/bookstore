package com.example.bookstore.generator.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsBriefVO extends Goods {
    @ApiModelProperty(value = "商品类别名称")
    private String names;

    @ApiModelProperty(value = "商店名")
    private String shopname;

}

