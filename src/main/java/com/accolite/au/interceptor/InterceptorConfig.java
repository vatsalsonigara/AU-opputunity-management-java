package com.accolite.au.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Component
public class InterceptorConfig extends WebMvcConfigurationSupport{


	@Override
	protected void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }

}
