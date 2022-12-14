/**
 * @Description : 註冊攔截器
 * @ClassName : InterceptorConfig.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/14, frankchang
 *   1) First Release.
 */

package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springboot.interceptor.APIInterceptor;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private APIInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor)
				.addPathPatterns("/**");
		
	}
	
	
}
