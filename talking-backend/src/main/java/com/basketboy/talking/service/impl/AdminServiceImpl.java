package com.basketboy.talking.service.impl;

import com.basketboy.talking.mapper.AdminMapper;
import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.basketboy.talking.pojo.AdminBean;
import com.basketboy.talking.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminBean getAdminByName(String name) throws Exception {
        return adminMapper.getAdminByName(name);
    }

    @Override
    public void updateAdmin(AdminBean userBean) throws Exception {
        adminMapper.updateAdmin(userBean);
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        adminMapper.deleteUserById(userId);
    }

    @Override
    public void deleteUserByList(List<String> userIds) throws Exception {
        adminMapper.deleteUserByList(userIds);
    }


    @Override
    public BaseListResult getAllUser(Integer page, Integer row) {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<UserBean> list = adminMapper.getUserList();
        int total = (int) new PageInfo<>(list).getTotal();
        base.setData(list);
        base.setTotal(total);
        return base;
    }

    @Override
    public BaseListResult searchUserList(Integer page, Integer row, UserBean userBean) throws Exception {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<UserBean> list = adminMapper.searchUserList(userBean);
        int total = (int) new PageInfo<>(list).getTotal();
        base.setData(list);
        base.setTotal(total);
        return base;
    }

    @Override
    public void updateUserByBean(UserBean userBean) throws Exception {
        adminMapper.updateUserByBean(userBean);
    }

}
