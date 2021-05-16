package com.jinhua.service;

import com.jinhua.domain.PageBean;
import com.jinhua.domain.User;

import java.util.List;

/**
 * @author Jinhua
 */
public interface UserService {

    /**
     * 登录
     *
     * @param user 用户
     * @return 登录结果
     */
    boolean login(User user);

    /**
     * 注册
     *
     * @param user 用户
     * @return 注册结果
     */
    boolean register(User user);

    /**
     * 删除
     *
     * @param user 用户
     * @return 删除结果
     */
    boolean delete(User user);

    /**
     * 更新
     *
     * @param user 用户
     * @return 更新结果
     */
    boolean update(User user);

    /**
     * 获取全部
     *
     * @return 用户列表
     */
    List<User> getUserAll();

    /**
     * 分页查询用户
     *
     * @param pc       当前页
     * @param ps       页大小
     * @param criteria 查询条件
     * @return 用户列表
     */
    PageBean<User> getUserByPage(int pc, int ps, User criteria);
}
