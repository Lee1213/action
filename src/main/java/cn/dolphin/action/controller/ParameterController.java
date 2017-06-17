package cn.dolphin.action.controller;

import cn.dolphin.action.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by LiLinZhi on 17/6/17.
 */
@RestController
@RequestMapping("/param")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;

    /**
     * 获取url上的参数
     *
     * @return
     */
    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public Map<String, Object> getParameter() {
        Map<String, Object> result = parameterService.getParameters();

        return result;
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public Map<String, Object> getParameter1(@RequestParam(value = "name", required = false) String name) {
        Map<String, Object> result = parameterService.getParameters();

        result.remove("name");
        result.put("name", name);

        return result;
    }

}
