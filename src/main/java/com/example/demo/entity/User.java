package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;


@Data
@ApiModel(description = "用户实体")
public class User {

    @NotNull
    @ApiModelProperty(value = "用户编号")
    private Long id;

    @NotBlank
    @Size(min = 2, max = 5)
    @ApiModelProperty(value = "用户姓名")
    private String name;

    @NotNull
    @Max(100)
    @Min(10)
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @NotBlank
    @Email
    @ApiModelProperty(value = "用户邮箱")
    private String email;
}
