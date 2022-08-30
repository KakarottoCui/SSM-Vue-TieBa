package com.basketboy.talking.service.impl;

import com.basketboy.talking.mapper.AdminMapper;
import com.basketboy.talking.mapper.FlowMapper;
import com.basketboy.talking.service.FlowService;
import com.basketboy.talking.pojo.FlowBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FlowServiceIml implements FlowService {
    @Autowired
    FlowMapper flowMapper;
    @Autowired
    AdminMapper adminMapper;

    @Override
    public FlowBean getFlowData(String adminId) throws Exception {
        FlowBean flowBean = flowMapper.getFlowData();
        if (flowBean == null) {
            flowBean = new FlowBean();
            flowBean.setPostTime(new Date());
            addFlow(flowBean);
        }
        FlowBean temp = getAllCount();
        flowBean.setAllAdminCount(temp.getAllAdminCount());
        flowBean.setAllUserCount(temp.getAllUserCount());
        flowBean.setAllJokeCount(temp.getAllJokeCount());
        flowBean.setAllCommentCount(temp.getAllCommentCount());
        flowBean.setAllThumbCount(temp.getAllThumbCount());

        return flowBean;
    }

    @Override
    public void upDateFlow(FlowBean flowBean) throws Exception {
        flowMapper.upDateFlow(flowBean);
    }

    @Override
    public void addFlow(FlowBean flowBean) throws Exception {
        flowMapper.addFlow(flowBean);
    }

    @Override
    public FlowBean getAllCount() throws Exception {
        FlowBean flowBean = new FlowBean();
        flowBean.setAllAdminCount(adminMapper.getAdminCount());
        flowBean.setAllUserCount(adminMapper.getUserCount());
        flowBean.setAllJokeCount(adminMapper.getJokeCount());
        flowBean.setAllCommentCount(adminMapper.getCommentCount());
        flowBean.setAllThumbCount(adminMapper.getThumbCount());
        return flowBean;
    }
}
