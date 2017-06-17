package cn.dolphin.action.spring.api.exception.handler;

import cn.dolphin.action.exception.CommonException;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiLinZhi on 17/6/15.
 */

/**
 * 捕获Controller层异常
 * 使用注解： @ControllerAdvice、@ExceptionHandler
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class GlobalControllerExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    /**
     * 常规异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public String handleException(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(500,
                GlobalExceptionResponseConstants.COMMON_ERROR_CODE,
                GlobalExceptionResponseConstants.COMMON_ERROR_MESSAGE);

        return JSON.toJSONString(exceptionResponse);
    }

    /**
     * 自定义异常
     *
     * @param commonEx
     * @return
     */

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponse handleException(CommonException commonEx) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        BeanUtils.copyProperties(commonEx, exceptionResponse);

        return exceptionResponse;
    }

}
