package com.basketboy.talking.mapper;

import com.basketboy.talking.pojo.BannerBean;

import java.util.List;

/**
 * @author ：xandone
 * created on  ：2019/1/17 16:33
 * description：
 */
public interface BannerMapper {
    List<BannerBean> getBannerData();

    void addBanner(BannerBean bean);

    void deleteBannerById(String articelId);
}
