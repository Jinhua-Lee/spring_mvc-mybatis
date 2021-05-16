package com.jinhua.service.impl;

import com.jinhua.domain.PageBean;
import com.jinhua.domain.User;
import com.jinhua.mapper.UserMapper;
import com.jinhua.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jinhua
 */
@Data
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    private PageBean<User> userPageBean;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    @Qualifier("pageBean")
    public void setUserPageBean(PageBean<User> userPageBean) {
        this.userPageBean = userPageBean;
    }

    @Override
    public boolean login(User user) {
        User u = userMapper.getUserByLoginName(user);
        return u.getPwd().equals(user.getPwd());
    }

    @Override
    public boolean register(User user) {
        return userMapper.addUser(user) > 0;
    }

    @Override
    public boolean delete(User user) {
        return userMapper.deleteUserById(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public List<User> getUserAll() {
        return userMapper.getUserAll();
    }

    @Override
    public PageBean<User> getUserByPage(int pc, int ps, User criteria) {
        userPageBean.setPageCurrent(pc);
        userPageBean.setPageSize(ps);
        List<User> userByPage = userMapper.getUserByPage((pc - 1) * ps, ps, criteria);
        userPageBean.setBeanList(userByPage);
        Integer totalCount = userMapper.getTotalCount(0, 0, criteria);
        userPageBean.setTotalRecord(totalCount);
        userPageBean.setTotalPages();
        return userPageBean;
    }
}
