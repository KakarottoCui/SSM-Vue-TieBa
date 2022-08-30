package com.basketboy.talking.service.impl;

import com.basketboy.talking.mapper.ApkMapper;
import com.basketboy.talking.service.ApkService;
import com.basketboy.talking.pojo.ApkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApkServiceImpl implements ApkService {
    @Autowired
    ApkMapper apkMapper;

    @Override
    public ApkBean getLastApk() {
        return apkMapper.getLastApk();
    }
}
