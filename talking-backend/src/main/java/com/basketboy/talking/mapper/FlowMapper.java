package com.basketboy.talking.mapper;

import com.basketboy.talking.pojo.FlowBean;

/**
 * @author ：xandone
 * created on  ：2019/6/12 16:22
 * description：
 */
public interface FlowMapper {
    void addFlow(FlowBean flowBean);

    FlowBean getFlowData();

    void upDateFlow(FlowBean flowBean);
}
