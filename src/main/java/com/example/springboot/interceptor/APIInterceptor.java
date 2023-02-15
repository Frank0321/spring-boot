/**
 * @Description : 實作攔截器功能
 * @ClassName : APIInterceptor.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/14, frankchang
 *   1) First Release.
 */

package com.example.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class APIInterceptor implements HandlerInterceptor {
	
	/**
	 * 進入 controller 之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	
		log.info("before controller ");
		return true;
	}
	

	/**
	 * 進入 controller 之後
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		log.info("after controller ");
	}

	
	/**
	 * 整個請求結束之後
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		log.info("after completion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
