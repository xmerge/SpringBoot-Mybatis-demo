package com.example.demo.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Xmerge
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "用户数据对象")
public class UserDO {
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Integer id;
    /**
     * 账号
     */
    @ApiModelProperty(value = "用户账号")
    private String username;
    /**
     * 密码（明文）
     * ps：生产环境下，明文
     */
    @ApiModelProperty(value = "用户密码")
    private String password;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}