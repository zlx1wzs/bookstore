package com.example.bookstore.generator.entity;

import com.example.bookstore.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收藏
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Favor对象", description = "收藏")
public class Favor extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联使用者id")
    private String userId;

    @ApiModelProperty(value = "关联商品id")
    private String goodsId;

    @ApiModelProperty(value = "创建时间YYY-MM-DD-hh-mm-ss")
    private String createTime;


}
