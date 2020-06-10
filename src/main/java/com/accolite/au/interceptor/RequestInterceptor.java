package com.accolite.au.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private Map<String, String> tokenMapper = new HashMap<String, String>(); 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map<String, String> headers = getAllHeaders(request);
		if(headers.containsKey("login")) {
			tokenMapper.put(headers.get("email"),headers.get("authtoken"));
		}
		else if(tokenMapper.containsKey(headers.get("email")) && tokenMapper.get(headers.get("email")).equals(headers.get("authtoken"))) {
			return super.preHandle(request, response, handler);
		}
		else {
			response.setStatus(401);
		}
		return super.preHandle(request, response, handler);
	}
	private Map<String, String> getAllHeaders(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getParameterNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getParameter(key);	
            map.put(key, value);
        }
		return map;
	}

}
