package com.basketboy.talking.controller;

import com.basketboy.talking.config.Config;
import com.basketboy.talking.pojo.Base.BaseResult;
import com.basketboy.talking.service.AdminService;
import com.basketboy.talking.service.FlowService;
import com.basketboy.talking.pojo.FlowBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/flow")
public class FlowController {
    @Autowired
    FlowService flowService;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/flowData")
    @ResponseBody
    public BaseResult getFlowData(@RequestParam(value = "adminId") String adminId) {
        BaseResult baseResult = new BaseResult();
        List<FlowBean> list = new ArrayList<>();
        try {
            FlowBean result = flowService.getFlowData(adminId);
            list.add(result);
            baseResult.setData(list);
            if (result != null) {
                baseResult.setCode(Config.SUCCESS_CODE);
                baseResult.setMsg(Config.MES_REQUEST_SUCCESS);
                return baseResult;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }

}
