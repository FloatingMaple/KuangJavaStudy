package com.maple.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 字符编码过滤器
 * author: maple_w
 * date: 2023/1/30 周一
 */
public class CharacterEncodingFilter implements Filter {

    /**
     * 过滤器初始化
     * web服务启动时就进行了初始化，随时等待过滤对象出现
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter 初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前...");
        // 拦截器处理后继续请求(转交该请求)
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("CharacterEncodingFilter 执行后...");
    }

    /**
     * 过滤器销毁
     * web服务器关闭时，过滤器会进行销毁
     */
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter 销毁...");
    }
}
