package cn.dolphin.action.service;

import cn.dolphin.action.thread.ThreadParameter;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by LiLinZhi on 17/6/17.
 */
@Service
public class ParameterService {

    public Map<String, Object> getParameters() {
        Map<String, Object> result = Maps.newHashMap();

        String name = ThreadParameter.getName();
        Integer age = ThreadParameter.getAge();

        result.put("name", name);
        result.put("age", age);

        return result;
    }

}
