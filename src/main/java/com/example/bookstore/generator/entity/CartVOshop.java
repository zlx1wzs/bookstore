package com.example.bookstore.generator.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CartVOshop {
    @ApiModelProperty(value = "商店名")
    private String shopname;

    @ApiModelProperty(value = "商店id")
    private String shopId;
}
