package cn.dolphin.action.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by LiLinZhi
 * Date: 17/7/9
 * Time: 上午2:24
 * Version: 1.0
 */
public class LogFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Log System Init!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Request Url: {}.", request.getLocalName());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("Log System Destroy!");
    }
}
