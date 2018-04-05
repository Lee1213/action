package cn.dolphin.action.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiLinZhi
 * @date 2018-04-05 下午8:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("xml")
public class XmlResponseBo {

    @XStreamAlias("user_name")
    private String userName;

    @XStreamAlias("user_age")
    private Integer userAge;

}
