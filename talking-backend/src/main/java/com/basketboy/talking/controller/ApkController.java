package com.basketboy.talking.controller;

import com.basketboy.talking.config.Config;
import com.basketboy.talking.pojo.Base.BaseResult;
import com.basketboy.talking.service.ApkService;
import com.basketboy.talking.pojo.ApkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "apk")
public class ApkController {
    @Autowired
    ApkService apkService;

    @RequestMapping(value = "/checkversion")
    @ResponseBody
    public BaseResult getLastApk() {
        BaseResult baseResult = new BaseResult();
        try {
            ApkBean apkBean = apkService.getLastApk();
            List<ApkBean> list = new ArrayList<>();
            list.add(apkBean);
            baseResult.setData(list);
            baseResult.setCode(Config.SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }
}
