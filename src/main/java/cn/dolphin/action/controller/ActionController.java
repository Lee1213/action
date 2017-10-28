package cn.dolphin.action.controller;

import cn.dolphin.action.service.ActionService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LiLinZhi
 * Date: 17/6/9
 * Time: 上午2:24
 * Version: 1.0
 */
@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/action", method = RequestMethod.GET)
    public List<String> action() throws Exception {
        List list = Lists.newArrayList();
        list.add("123");

        actionService.getAction();

        return list;
    }
}
