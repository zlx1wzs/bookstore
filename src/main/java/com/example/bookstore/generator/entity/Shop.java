package com.example.bookstore.generator.entity;

import com.example.bookstore.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商店
 * </p>
 *
 * @author wzs
 * @since 2022-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Shop对象", description = "商店")
public class Shop extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商店名称")
    private String ids;

    @ApiModelProperty(value = "商店名称")
    private String shopname;

    @ApiModelProperty(value = "商店简介")
    private String introduction;

    @ApiModelProperty(value = "商店地址")
    private String address;

    @ApiModelProperty(value = "商店图片")
    private String shoplog;

    @ApiModelProperty(value = "联系电话")
    private String telphone;

    @ApiModelProperty(value = "商店所属id，关联user表")
    private String userId;

    @ApiModelProperty(value = "创建时间")
    private String createTime;


}
