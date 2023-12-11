package com.example.demo.mapper;

import com.example.demo.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 用户数据访问对象的数据库 mapper 接口。
 * @author Xmerge
 */
@Repository
public interface UserMapper {
    /**
     * 插入用户数据到数据库。
     *
     * @param user 要插入的用户数据对象
     * @return 执行成功插入操作的记录数
     */
    int insert(UserDO user);

    /**
     * 根据主键更新用户数据到数据库。
     *
     * @param user 要更新的用户数据对象
     * @return 执行成功更新操作的记录数
     */
    int updateById(UserDO user);

    /**
     * 根据主键从数据库删除用户数据。
     *
     * @param id 要删除的用户数据的主键
     * @return 执行成功删除操作的记录数
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据用户名从数据库删除用户数据。
     *
     * @param username 要删除的用户名
     * @return 执行成功删除操作的记录数
     */
    int deleteByUserName(@Param("username") String username);

    /**
     * 从数据库查询指定主键的用户数据。
     *
     * @param id 要查询的用户数据的主键
     * @return 查询到的用户数据对象
     */
    UserDO selectById(@Param("id") Integer id);

    /**
     * 从数据库查询指定用户名的用户数据。
     *
     * @param username 要查询的用户名
     * @return 查询到的用户数据对象
     */
    UserDO selectByUsername(@Param("username") String username);

    /**
     * 从数据库查询指定主键集合的所有用户数据。
     *
     * @param ids 要查询的用户数据的主键集合
     * @return 查询到的用户数据对象集合
     */
    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

    List<UserDO> selectAll();
}
