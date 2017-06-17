package cn.dolphin.action.filter;

import cn.dolphin.action.thread.ThreadParameter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LiLinZhi on 17/6/16.
 */

/**
 * 将请求的参数解析成公共参数.
 * 继承 OncePerRequestFilter
 * 实现 doFilterInternal
 * 转化url上的参数
 * filterChain.doFilter(request, response)
 */
public class ThreadParameterFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ThreadParameter.clear();

        String name = request.getParameter("name");
        if (StringUtils.isNotBlank(name)) {
            ThreadParameter.setName(name);
        }

        String age = request.getParameter("age");
        if (StringUtils.isNotBlank(age)) {
            ThreadParameter.setAge(Integer.valueOf(age));
        }

        // TODO: 原因???
        filterChain.doFilter(request, response);

    }
}
