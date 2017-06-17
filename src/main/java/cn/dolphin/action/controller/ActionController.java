package cn.dolphin.action.controller;

import cn.dolphin.action.service.ActionService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LiLinZhi on 17/6/14.
 */
@Controller
@RequestMapping("/task")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<String> action() throws Exception {
        List list = Lists.newArrayList();
        list.add("123");

        actionService.getActions();

        return list;
    }
}
