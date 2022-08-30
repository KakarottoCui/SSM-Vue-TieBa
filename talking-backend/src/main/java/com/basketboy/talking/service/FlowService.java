package com.basketboy.talking.service;


import com.basketboy.talking.pojo.FlowBean;

public interface FlowService {

    FlowBean getFlowData(String adminId) throws Exception;

    void upDateFlow(FlowBean flowBean) throws Exception;

    void addFlow(FlowBean flowBean) throws Exception;

    FlowBean getAllCount() throws Exception;

}
