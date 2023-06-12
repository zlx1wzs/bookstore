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
* @since 2023-05-25
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Jian对象", description="")
    public class Jian extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String jobid;

            @ApiModelProperty(value = "发布者id")
    private String otherid;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "创建时间")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private String state;
    @ApiModelProperty(value = "创建时间")
    private String position;
    @ApiModelProperty(value = "创建时间")
    private String phone;

}
