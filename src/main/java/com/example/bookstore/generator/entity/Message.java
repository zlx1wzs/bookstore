package com.example.bookstore.generator.entity;

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
* @since 2023-05-26
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Message对象", description="")
    public class Message extends BaseEntity {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "聊天对象id")
    private String userid;

            @ApiModelProperty(value = "聊天类容")
    private String message;


     @ApiModelProperty(value = "创建时间")
            private String createTime;;


}
