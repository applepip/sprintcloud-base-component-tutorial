package com.spring.cloud.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component //主键注册
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        return "pre";
        return FilterConstants.PRE_TYPE;
    }

    //处理细节排序，数越小优先级约高
    @Override
    public int filterOrder() {
        return 0;
    }

    //控制使用过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器实现
    @Override
    public Object run() {

        //RequestContext ctx共享信息
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        String token = request.getHeader("token");
//
//        if(token == null || token.equals("")){
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("{\"msg\":\"401, access without permission, pls login first.\"}");
//            return "access denied";
//        }
//
//        return "pass";

        //过滤器协调配合
        String key = request.getParameter("key");
        System.out.println(key + "access filter 1");
        ctx.set("thirdfilter", true);
        if("1".equals(key))
        {
            ctx.setSendZuulResponse(false);
        }else if("".equals(key)){
            ctx.set("thirdfilter", false);
        }

        return null;

    }
}
