package com.basketboy.talking.service;

import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.pojo.PlankTalkBean;
import com.basketboy.talking.pojo.TalkBean;

public interface PlankService {

    TalkBean addTalk(String userId, String talkStr) throws Exception;

    PlankTalkBean addPlankTalk(String content) throws Exception;

    BaseListResult getTalkList(Integer size) throws Exception;

    BaseListResult getPlankList(Integer page, Integer row) throws Exception;

    PlankTalkBean getLastPlank() throws Exception;

    void deletePlankById(String id) throws Exception;

    void deleteTalkById(String id) throws Exception;

}
