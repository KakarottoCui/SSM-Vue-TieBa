package com.basketboy.talking.service;

import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.pojo.UserBean;

import java.util.List;

public interface UserService {
    UserBean addUser(UserBean userBean) throws Exception;

    UserBean getUserByName(String name) throws Exception;

    UserBean getUserById(String userId) throws Exception;

    UserBean getUserByNick(String userId) throws Exception;

    void updateUser(UserBean userBean) throws Exception;

    void deleteUserById(String userId) throws Exception;

    void deleteUserByList(List<String> userIds) throws Exception;

    BaseListResult getAllUser(Integer page, Integer row) throws Exception;

}
