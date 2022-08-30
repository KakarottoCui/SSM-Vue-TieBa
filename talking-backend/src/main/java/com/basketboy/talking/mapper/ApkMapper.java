package com.basketboy.talking.mapper;

import com.basketboy.talking.pojo.ApkBean;

/**
 * @author ：xandone
 * created on  ：2019/7/3 11:25
 * description：
 */
public interface ApkMapper {
    ApkBean getLastApk();

    void addLastApk(ApkBean bean);
}
