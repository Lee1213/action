package cn.dolphin.action.util;

import cn.dolphin.action.bo.OrderRespBo;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author LiLinZhi
 * @date 2018-04-05 下午10:27
 */
public class JsonUtils {

    /**
     * 将string转成对象,可嵌套,可转化字段名称
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Object> orderResponse = Maps.newHashMap();
        orderResponse.put("err_no", 1001);
        orderResponse.put("err_msg", "失败");

        Map<String, Object> orderRespBo = Maps.newHashMap();
        orderRespBo.put("id", "123");
        orderRespBo.put("response", orderResponse);

        String result = JSON.toJSONString(orderRespBo);
        System.out.println("result:" + result);

        OrderRespBo respBo = JSON.parseObject(result, OrderRespBo.class);
        System.out.println("orderRespBo:" + respBo.toString());
    }
}
