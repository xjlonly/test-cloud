package com.example.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public String filterType() {
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
    public Object run() {
        var ctx =  RequestContext.getCurrentContext();
        var request = ctx.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object token = request.getParameter("accessToken");
//        if(token == null){
//            logger.warn("access token is null");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return false;
//        }
        logger.warn("access token ok ");
        return null;
    }
}
