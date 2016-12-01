package com.bs.beyond.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import net.sf.json.JSONObject;

import com.bs.beyond.core.BsBO;

public class ExceptionInterceptor extends HandlerInterceptorAdapter
{

    protected Logger logger = Logger.getLogger(ExceptionInterceptor.class);

    @Override
    public void afterCompletion(
		HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        Exception ex) throws Exception {

        if (ex != null) {

        	BsBO bo = new BsBO();

        	JSONObject jsonObject = JSONObject.fromObject(bo);
        	String json = jsonObject.toString();

        	response.setContentType("application/json; charset=UTF-8");
        	response.getWriter().print(json);
        	response.flushBuffer();

        	this.logger.error(ex.getMessage(), ex);
        }
    }
}
