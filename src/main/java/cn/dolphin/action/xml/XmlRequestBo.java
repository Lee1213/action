package cn.dolphin.action.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiLinZhi
 * @date 2018-04-05 下午8:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("xml")
public class XmlRequestBo {

    @XStreamAlias("user_id")
    private String userId;

    @XStreamAlias("user_name")
    private String userName;

    @XStreamAlias("user_age")
    private Integer userAge;
}
