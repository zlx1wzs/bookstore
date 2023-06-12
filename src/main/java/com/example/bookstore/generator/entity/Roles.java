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
* @since 2022-12-29
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    @ApiModel(value="Roles对象", description="")
    public class Roles extends BaseEntity {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "角色")
    private String roless;


}
