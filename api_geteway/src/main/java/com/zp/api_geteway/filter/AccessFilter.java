package com.zp.api_geteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaopeng
 * @create 2021-02-26 17:47
 */
public class AccessFilter extends ZuulFilter {

    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        //请求在路由之前
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            //ctx.setSendZuulResponse(false);
            //直接返回错误码
            //ctx.setResponseStatusCode(401);
            //设置响应的内容
            ctx.setResponseBody("请拿到accessToken再访问此网址....");
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
