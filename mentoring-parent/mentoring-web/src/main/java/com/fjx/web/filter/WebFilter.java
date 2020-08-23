package com.fjx.web.filter;/*
 * @program: tensquare_parent
 * @Date: 2020-05-02 10:18
 * @Author: Jason
 * @Description:
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import until.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebFilter extends ZuulFilter {
    @Bean
    private JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    /**
     * 表示过滤器在什么时候执行，如果是pre 则在请求前之前执行，post 在请求后后执行
     *
     * @param []
     * @Return: java.lang.String
     */

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 可能有很多过滤器，多个过滤器执行的优先级，数字越小则越优先执行
     *
     * @param []
     * @Return: int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否开启，默认false，true 是开启
     *
     * @param []
     * @Return: boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内部执行的操作，return 任何object 的值表示继续执行
     * setsendzullRespponse（false）表示不再执行
     *
     * @param []
     * @Return: java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("Zuul 过滤器");
        // 得到 request 上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 得到request 域
        HttpServletRequest request = requestContext.getRequest();
        // 获取头信息
        String authHeader = (String) request.getHeader("Authorization");

        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }

        String url = request.getRequestURI().toString();

        if (url.indexOf("/admin/login") > 0) {
            System.out.println("登陆界面" + url);

            return null;
        }
        // 判断是否有头信息
        if (authHeader != null) {
            requestContext.addZuulRequestHeader("Authorization", authHeader);
        }
        return null;
    }
}
