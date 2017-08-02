package cn.dolphin.action.interceptor;

import cn.dolphin.action.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiLinZhi
 * Date: 17/7/31
 * Time: 下午6:35
 * Version: 1.0
 */
public class SessionInterceptor implements HandlerInterceptor {

    public SessionInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = CookieUtils.getCookieValue(request, "DOL_SESSION", true);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        String sessionId = "123";
        if (StringUtils.isNotBlank(sessionId)) {
            CookieUtils.setCookie(request, response, "DOL_SESSION", sessionId, 60 * 30, true);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}

