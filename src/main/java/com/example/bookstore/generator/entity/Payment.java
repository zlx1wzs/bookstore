package com.example.bookstore.generator.entity;

    import java.time.LocalDateTime;
    import com.baomidou.mybatisplus.annotation.TableField;
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
* @since 2023-05-25
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Payment对象", description="")
    public class Payment extends BaseEntity {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "支付单号")
    private Integer paymentid;

            @ApiModelProperty(value = "备注")
    private String other;

            @ApiModelProperty(value = "支付状态：true-已支付，flase-未支付")
        @TableField("btnStatus")
    private int btnStatus;

            @ApiModelProperty(value = "交易时间")
    private String time;

            @ApiModelProperty(value = "工人id")
    private Integer workid;

            @ApiModelProperty(value = "基本工资（元）")
    private Integer city;

            @ApiModelProperty(value = "奖励工资(元)")
    private Integer address;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "创建时间")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private String province;
    @ApiModelProperty(value = "创建时间")
    private String zip;


}
