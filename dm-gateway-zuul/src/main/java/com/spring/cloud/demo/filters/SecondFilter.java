package com.spring.cloud.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component //主键注册
public class SecondFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        return "pre";
        return FilterConstants.PRE_TYPE;
    }

    //处理细节排序，数越小优先级约高
    @Override
    public int filterOrder() {
        return 1;
    }

    //控制使用过滤器
    @Override
    public boolean shouldFilter() {
        //根据前面内容判断是否执行
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.sendZuulResponse();
    }

    //过滤器实现
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String key = request.getParameter("key");
        System.out.println(key + "access filter 2");
        if("2".equals(key))
        {
            ctx.setSendZuulResponse(false);
        }

        return null;

    }
}
