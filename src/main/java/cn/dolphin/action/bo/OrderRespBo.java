package cn.dolphin.action.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRespBo {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "response")
    private OrderResponse orderResponse;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderResponse {
        @JSONField(name = "err_no")
        private Integer errorNo;

        @JSONField(name = "err_msg")
        private String errorMsg;
    }
}
