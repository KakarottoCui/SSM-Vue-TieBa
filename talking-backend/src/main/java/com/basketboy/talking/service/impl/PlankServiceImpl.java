package com.basketboy.talking.service.impl;

import com.basketboy.talking.mapper.PlankMapper;
import com.basketboy.talking.mapper.UserMapper;
import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.service.PlankService;
import com.basketboy.talking.utils.IDUtils;
import com.basketboy.talking.utils.SimpleUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.basketboy.talking.pojo.PlankTalkBean;
import com.basketboy.talking.pojo.TalkBean;
import com.basketboy.talking.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlankServiceImpl implements PlankService {
    @Autowired
    PlankMapper plankMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public TalkBean addTalk(String userId, String talkStr) throws Exception {
        TalkBean talkBean = new TalkBean(userId, talkStr);
        talkBean.setSendTime(new Date());
        talkBean.setTalkId(IDUtils.RandomId());
        UserBean userBean = userMapper.getUserById(userId);
        talkBean.setUserNick(userBean.getNickname());
        talkBean.setUserIcon(userBean.getUserIcon());
        plankMapper.addTalk(talkBean);
        return talkBean;
    }

    @Override
    public PlankTalkBean addPlankTalk(String content) throws Exception {
        PlankTalkBean plankTalkBean = new PlankTalkBean(content);
        plankTalkBean.setSendTime(new Date());
        plankTalkBean.setPlankId(IDUtils.RandomId());
        plankMapper.addPlankTalk(plankTalkBean);
        return plankTalkBean;
    }

    @Override
    public BaseListResult getTalkList(Integer size) throws Exception {
        BaseListResult base = new BaseListResult();
        size = size == null ? 10 : size;
        PageHelper.startPage(1, size);
        List<TalkBean> list = plankMapper.getTalkList();
        for (TalkBean bean : list) {
            UserBean userBean = userMapper.getUserById(bean.getUserId());
            bean.setUserNick(userBean.getNickname());
            bean.setUserIcon(userBean.getUserIcon());
            bean.setSendTimeStr(SimpleUtils.getFriendlyTime(bean.getSendTime()));
        }
        int total = (int) new PageInfo<>(list).getTotal();
        base.setData(list);
        base.setTotal(total);
        return base;
    }

    @Override
    public BaseListResult getPlankList(Integer page, Integer row) throws Exception {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<PlankTalkBean> list = plankMapper.getPlankList();
        int total = (int) new PageInfo<>(list).getTotal();
        base.setData(list);
        base.setTotal(total);
        return base;
    }

    @Override
    public PlankTalkBean getLastPlank() throws Exception {
        PlankTalkBean bean = plankMapper.getLastPlank();
        bean.setSendTimeStr(SimpleUtils.getFriendlyTime(bean.getSendTime()));
        return bean;
    }

    @Override
    public void deletePlankById(String id) throws Exception {
        plankMapper.deletePlankById(id);
    }

    @Override
    public void deleteTalkById(String id) throws Exception {
        plankMapper.deleteTalkById(id);

    }
}
