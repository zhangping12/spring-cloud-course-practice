package com.imooc.course.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 描述：前置过滤器
 */
@Component
public class PreRequestFilter extends ZuulFilter {

    //指定过滤器类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //执行顺序
    @Override
    public int filterOrder() {
        return 5;
    }

    //是不是要走这个过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //走完过滤器，要执行的业务逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        System.out.println("URI:" + currentContext.getRequest().getRequestURI());
        return null;
    }
}
