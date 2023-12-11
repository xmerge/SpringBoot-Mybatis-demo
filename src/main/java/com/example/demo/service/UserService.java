package com.example.demo.service;

import com.example.demo.entity.UserDO;

import java.util.Collection;
import java.util.List;

/**
 * 用户服务接口
 * @author Xmerge
 */
public interface UserService {
    /**
     * 插入新用户
     * @param user 要插入的用户对象
     * @return 返回插入的行数
     */
    int insert(UserDO user);

    /**
     * 根据ID更新用户
     * @param user 要更新的用户对象
     * @return 返回更新的行数
     */
    int updateById(UserDO user);
    /**
     * 根据ID删除用户
     * @param id 要删除的用户ID
     * @return 返回删除的行数
     */
    int deleteById(Integer id);

    /**
     * 根据用户名删除记录
     * @param username 待删除记录的用户名
     * @return 删除的记录数量
     */
    int deleteByUserName(String username);

    /**
     * 根据ID查询用户
     * @param id 要查询的用户ID
     * @return 返回查询到的用户对象
     */
    UserDO selectById(Integer id);

    /**
     * 根据用户名查询用户
     * @param username 要查询的用户名
     * @return 返回查询到的用户对象
     */
    UserDO selectByUsername(String username);

    /**
     * 根据ID列表查询用户
     * @param ids 要查询的用户ID列表
     * @return 返回查询到的用户对象列表
     */
    List<UserDO> selectByIds(Collection<Integer> ids);

    /**
     * 查询所有用户
     * @return 返回查询到的用户对象列表
     */
    List<UserDO> selectAll();
}