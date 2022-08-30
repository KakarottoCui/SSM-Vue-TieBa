package com.basketboy.talking.service.impl;

import com.basketboy.talking.mapper.BannerMapper;
import com.basketboy.talking.pojo.Base.BaseResult;
import com.basketboy.talking.service.BannerService;
import com.basketboy.talking.pojo.BannerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public BaseResult getBannerData() {
        BaseResult result = new BaseResult();
        List<BannerBean> list = bannerMapper.getBannerData();
        result.setData(list);
        return result;
    }

    @Override
    public BannerBean addBanner(BannerBean bean) throws Exception {
        bannerMapper.addBanner(bean);
        return bean;
    }

    @Override
    public void deleteBannerById(String articelId) throws Exception {
        bannerMapper.deleteBannerById(articelId);
    }
}
