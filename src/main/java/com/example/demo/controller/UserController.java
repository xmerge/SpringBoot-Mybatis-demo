package com.example.demo.controller;

import com.alibaba.fastjson2.JSON;
import com.example.demo.entity.UserDO;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户Controller
 * @author Xmerge
 */
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下
@Api(tags = "用户管理",value = "User Controller")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 插入新用户
     * @param user 要插入的用户对象
     * @return 返回插入的行数
     */
    @PostMapping(value = "/insert")
    @ApiOperation(value = "插入用户", notes = "向数据库中插入用户信息")
    public int insert(@RequestBody UserDO user) {
        return userService.insert(user);
    }

    /**
     * 根据用户名删除用户
     * @param username 用户名称
     * @return 返回结果
     */
    @PostMapping(value = "/deleteUserByName")
    @ApiOperation(value = "根据用户名删除用户", notes = "根据用户名从数据库中删除用户信息")
    public int deleteUserByName(@RequestBody String username) {
        return userService.deleteByUserName(username);
    }

    /**
     * 根据用户名更新用户
     * @param username 用户名称
     * @return 返回结果
     */
    @PostMapping(value = "/getUserByName")
    @ApiOperation(value = "根据用户名获取用户信息", notes = "根据用户名从数据库中获取用户信息")
    public String getUserByName(@RequestBody String username) {
        return userService.selectByUsername(username).toString();
    }

    /**
     * 获取所有用户信息
     * @return 所有用户信息
     */
    @GetMapping(value = "/")
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户信息")
    public String getAllUser() {
        return JSON.toJSONString(userService.selectAll());
    }
}
