package com.basketboy.talking.service.impl;

import com.basketboy.talking.mapper.UserMapper;
import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.basketboy.talking.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean addUser(UserBean userBean) {
        userMapper.addUser(userBean);
        return userBean;
    }

    @Override
    public UserBean getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public UserBean getUserById(String userId) throws Exception {
        return userMapper.getUserById(userId);
    }

    @Override
    public UserBean getUserByNick(String userId) throws Exception {
        return userMapper.getUserByNick(userId);
    }

    @Override
    public void updateUser(UserBean userBean) throws Exception {
        userMapper.updateUser(userBean);
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void deleteUserByList(List<String> userIds) throws Exception {
        userMapper.deleteUserByList(userIds);
    }


    @Override
    public BaseListResult getAllUser(Integer page, Integer row) {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<UserBean> list = userMapper.getUserList();
        int total = (int) new PageInfo<>(list).getTotal();
        base.setData(list);
        base.setTotal(total);
        return base;
    }
}
