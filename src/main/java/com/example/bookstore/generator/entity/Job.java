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
* @since 2023-05-24
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Job对象", description="")
    public class Job extends BaseEntity {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "职位名称")
    private String postname;

            @ApiModelProperty(value = "职位类型")
    private String type;

            @ApiModelProperty(value = "公司地址")
    private String address;

            @ApiModelProperty(value = "职位发布状态")
    private String state;

            @ApiModelProperty(value = "职位需求数量")
    private Integer number;

            @ApiModelProperty(value = "职位学历要求")
    private String education;

            @ApiModelProperty(value = "职位详情")
    private String introduction;

            @ApiModelProperty(value = "工资")
    private String salary;

            @ApiModelProperty(value = "公司名称")
    private String name;

            @ApiModelProperty(value = "工作经历")
    private String workexperience;
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "时间状态")
    private String now;

    @ApiModelProperty(value = "时间状态")
    private String userid;
}
