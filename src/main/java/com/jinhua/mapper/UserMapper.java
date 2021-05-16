package com.jinhua.mapper;

import com.jinhua.domain.User;

import java.util.List;

/**
 * @author Jinhua
 */
public interface UserMapper {

    /**
     * 返回所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> getUserAll();

    /**
     * 根据用户实体添加到用户Usr表
     *
     * @param user 用户
     * @return 添加结果
     */
    int addUser(User user);

    /**
     * 根据ID值删除用户
     *
     * @param user 用户
     * @return 删除结果
     */
    int deleteUserById(User user);

    /**
     * 根据ID值更新用户信息
     *
     * @param user 用户
     * @return 更新结果
     */
    int updateUser(User user);

    /**
     * 通过Name值找到用户
     *
     * @param user 用户
     * @return 查找结果
     */
    User getUserByLoginName(User user);

    /**
     * 分页查询到用户
     *
     * @param x        偏移量
     * @param y        最大数目
     * @param criteria 查询条件
     * @return 用户列表
     */
    List<User> getUserByPage(int x, int y, User criteria);

    /**
     * 分页查询符合条件的所有记录数
     *
     * @param x        偏移量
     * @param y        最大数目
     * @param criteria 查询条件
     * @return 数据量
     */
    Integer getTotalCount(int x, int y, User criteria);
}
