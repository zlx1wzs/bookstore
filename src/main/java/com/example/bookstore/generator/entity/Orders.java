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
* @since 2022-12-24
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Orders对象", description="")
    public class Orders extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userId;

    private Double totalprice;

    private String status;

    private String createTime;

    private String refund;

    private String refundAdmin;

    private String cancleReason;

    private String goodsId;

    private Integer shopnumber;


}
