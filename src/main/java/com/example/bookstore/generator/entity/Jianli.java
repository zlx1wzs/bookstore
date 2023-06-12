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
    @ApiModel(value="Jianli对象", description="")
    public class Jianli extends BaseEntity {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "名称")
    private String username;

            @ApiModelProperty(value = "性别")
    private String sex;

            @ApiModelProperty(value = "身份")
    private String shenfen;

            @ApiModelProperty(value = "年龄")
    private Integer age;

            @ApiModelProperty(value = "微信")
    private String weixin;

            @ApiModelProperty(value = "邮箱")
    private String email;

            @ApiModelProperty(value = "我的优势")
    private String advantage;

            @ApiModelProperty(value = "求职期望")
    private String desire;

            @ApiModelProperty(value = "工作经历")
    private String workexperience;

            @ApiModelProperty(value = "项目经历")
    private String projectexperience;

            @ApiModelProperty(value = "教育经历")
    private String educationexperience;

            @ApiModelProperty(value = "证书")
    private String certificate;
    @ApiModelProperty(value = "创建时间")
    private String createTime;


}
