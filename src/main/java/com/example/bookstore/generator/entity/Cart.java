package com.example.bookstore.generator.entity;

import com.example.bookstore.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Cart对象", description = "购物车")
public class Cart extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "创建时间")
    private String createTime;

}
