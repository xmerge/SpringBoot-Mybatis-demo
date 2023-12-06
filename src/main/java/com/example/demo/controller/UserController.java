package com.example.demo.controller;

import com.example.demo.entity.UserDO;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下
@Api(tags = "用户管理",value = "User Controller")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping(value = "/insert")
    @ApiOperation(value = "插入用户", notes = "向数据库中插入用户信息")
    public int insert(@RequestBody UserDO user) {
        return userService.insert(user);
    }

    @PostMapping(value = "/deleteUserByName")
    @ApiOperation(value = "根据用户名删除用户", notes = "根据用户名从数据库中删除用户信息")
    public int deleteUserByName(@RequestBody String username) {
        return userService.deleteByUserName(username);
    }
    @PostMapping(value = "/getUserByName")
    @ApiOperation(value = "根据用户名获取用户信息", notes = "根据用户名从数据库中获取用户信息")
    public String getUserByName(@RequestBody String username) {
        return userService.selectByUsername(username).toString();
    }
}
