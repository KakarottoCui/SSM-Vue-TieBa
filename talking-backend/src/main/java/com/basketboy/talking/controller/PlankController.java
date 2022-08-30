package com.basketboy.talking.controller;

import com.basketboy.talking.config.Config;
import com.basketboy.talking.pojo.Base.BaseListResult;
import com.basketboy.talking.pojo.Base.BaseResult;
import com.basketboy.talking.service.PlankService;
import com.basketboy.talking.service.UserService;
import com.basketboy.talking.utils.ResultHelper;
import com.basketboy.talking.pojo.PlankTalkBean;
import com.basketboy.talking.pojo.TalkBean;
import com.basketboy.talking.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/plank")
public class PlankController {
    @Autowired
    PlankService plankService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addTalk(@RequestParam(value = "userId") String userId, @RequestParam(value = "talk") String talk) {
        BaseResult baseResult = new BaseResult();
        try {
            UserBean user = userService.getUserById(userId);
            if (user == null) {
                return ResultHelper.getResult(Config.ERROR_CODE);
            }
            if (user.getBanned() == 1) {
                return ResultHelper.getResult(Config.ERROR_BANNED_CODE);
            }
            TalkBean talkBean = plankService.addTalk(userId, talk);
            List<TalkBean> list = new ArrayList<>();
            list.add(talkBean);
            baseResult.setData(list);
            baseResult.setCode(Config.SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }

    @RequestMapping(value = "/talkList")
    @ResponseBody
    public BaseListResult getTalkList(Integer size) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = plankService.getTalkList(size);
            if (result != null) {
                result.setCode(Config.SUCCESS_CODE);
                result.setMsg(Config.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }

    @RequestMapping(value = "/planktalk/list")
    @ResponseBody
    public BaseListResult getPlankList(@RequestParam(value = "page") Integer page,
                                       @RequestParam(value = "row") Integer row) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = plankService.getPlankList(page, row);
            if (result != null) {
                result.setCode(Config.SUCCESS_CODE);
                result.setMsg(Config.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }


    @RequestMapping(value = "/planktalk/lastplank")
    @ResponseBody
    public BaseResult getLastPlank() {
        BaseResult baseResult = new BaseResult();
        try {
            PlankTalkBean plankTalkBean = plankService.getLastPlank();
            List<PlankTalkBean> list = new ArrayList<>();
            list.add(plankTalkBean);
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
