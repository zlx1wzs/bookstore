package com.example.bookstore.generator.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
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
* @since 2023-06-09
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Coupon对象", description="")
    public class Coupon extends BaseEntity {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "优惠券价值")
    private BigDecimal value;

            @ApiModelProperty(value = "买满多少可用")
    private BigDecimal bottomPrice;

            @ApiModelProperty(value = "有效期")
    private LocalDateTime endTime;

            @ApiModelProperty(value = "持有者id")
    private String userId;

            @ApiModelProperty(value = "优惠券创建时间")
    private String createTime;

            @ApiModelProperty(value = "类型：是否过期")
    private String type;

            @ApiModelProperty(value = "优惠详情")
    private String descs;

            @ApiModelProperty(value = "来源商店编号")
    private String shopId;


}
