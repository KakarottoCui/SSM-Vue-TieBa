package com.basketboy.talking.service;

import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.pojo.AdminBean;
import com.basketboy.talking.pojo.UserBean;

import java.util.List;


public interface AdminService {
    AdminBean getAdminByName(String name) throws Exception;

    void updateAdmin(AdminBean userBean) throws Exception;

    void deleteUserById(String userId) throws Exception;

    void deleteUserByList(List<String> userIds) throws Exception;

    BaseListResult getAllUser(Integer page, Integer row) throws Exception;

    BaseListResult searchUserList(Integer page, Integer row, UserBean userBean) throws Exception;

    void updateUserByBean(UserBean userBean) throws Exception;

}
