package cn.dolphin.action.controller;

import cn.dolphin.action.service.ExceptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by LiLinZhi on 17/6/17.
 */
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @Autowired
    private ExceptionService exceptionService;

    @RequestMapping(value = "normal")
    public Map<String, Object> getNormal() {
        Map<String, Object> result = exceptionService.getResult();
        return result;
    }

    @RequestMapping(value = "/run")
    public Map<String, Object> getRunException() {
        Map<String, Object> result = exceptionService.getRunException();

        return result;
    }

    @RequestMapping(value = "/common")
    public Map<String, Object> getCommonException() {
        Map<String, Object> result = exceptionService.getCommonException();

        return result;
    }

}
