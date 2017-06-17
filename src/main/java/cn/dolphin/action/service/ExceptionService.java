package cn.dolphin.action.service;

import cn.dolphin.action.exception.CommonException;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by LiLinZhi on 17/6/17.
 */
@Service
public class ExceptionService {

    public Map<String, Object> getResult() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("status", 200);
        result.put("code", 10000);
        result.put("message", "OK!");

        return result;
    }

    public Map<String, Object> getRunException() {
        Map<String, Object> result = getResult();

        String[] arr = new String[2];
        String message = arr[2];
        result.put("message", message);

        return result;
    }

    public Map<String, Object> getCommonException() {
        Map<String, Object> result = null;
        try {
            getRunException();
        } catch (Exception e) {
            throw new CommonException(422, 10001, "崩溃了!");
        }

        return result;
    }
}
