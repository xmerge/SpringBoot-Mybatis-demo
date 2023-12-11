package com.example.demo.service.impl;

import com.example.demo.entity.UserDO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 用户服务类
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 插入新用户
     * @param user 要插入的用户对象
     * @return 返回插入的行数
     */
    public int insert(UserDO user) {
        // 实现插入逻辑
        return userMapper.insert(user);
    }

    /**
     * 根据ID更新用户
     * @param user 要更新的用户对象
     * @return 返回更新的行数
     */
    public int updateById(UserDO user) {
        // 实现更新逻辑
        return userMapper.updateById(user);
    }

    /**
     * 根据ID删除用户
     * @param id 要删除的用户ID
     * @return 返回删除的行数
     */
    public int deleteById(Integer id) {
        // 实现删除逻辑
        return userMapper.deleteById(id);
    }

    public int deleteByUserName(String username) {
        // 实现删除逻辑
        return userMapper.deleteByUserName(username);
    }

    /**
     * 根据ID查询用户
     * @param id 要查询的用户ID
     * @return 返回查询到的用户对象
     */
    public UserDO selectById(Integer id) {
        // 实现根据ID查询逻辑
        return userMapper.selectById(id);
    }

    /**
     * 根据用户名查询用户
     * @param username 要查询的用户名
     * @return 返回查询到的用户对象
     */
    public UserDO selectByUsername(String username) {
        // 实现根据用户名查询逻辑
        return userMapper.selectByUsername(username);
    }

    /**
     * 根据ID列表查询用户
     * @param ids 要查询的用户ID列表
     * @return 返回查询到的用户对象列表
     */
    public List<UserDO> selectByIds(Collection<Integer> ids) {
        // 实现根据ID列表查询逻辑
        return userMapper.selectByIds(ids);
    }

    /**
     * 查询所有用户
     * @return 返回查询到的用户对象列表
     */
    @Override
    public List<UserDO> selectAll() {
        return userMapper.selectAll();
    }

}
