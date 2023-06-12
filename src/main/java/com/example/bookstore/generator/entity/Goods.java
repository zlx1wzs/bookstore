package com.example.bookstore.generator.entity;

import com.example.bookstore.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wzs
 * @since 2022-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Goods对象", description = "")
public class Goods extends BaseEntity {

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

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "商品类别")
    private String category;

    @ApiModelProperty(value = "商品作者")
    private String author;

    @ApiModelProperty(value = "出版商")
    private String publisher;

    @ApiModelProperty(value = "商品描述")
    private String description;


}
