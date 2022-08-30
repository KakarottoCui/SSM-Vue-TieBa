package com.basketboy.talking.mapper;

import com.basketboy.talking.pojo.UserBean;

import java.util.List;

public interface UserMapper {
    void addUser(UserBean user);

    UserBean getUserByName(String name);

    UserBean getUserById(String userId);

    UserBean getUserByNick(String nick);

    void updateUser(UserBean userBean);

    void deleteUserById(String userId);

    void deleteUserByList(List<String> userIds);

    List<UserBean> getUserList();
}
