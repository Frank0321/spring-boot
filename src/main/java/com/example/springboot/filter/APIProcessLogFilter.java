/**
 * @Description : 使用 filter 紀錄 req res 
 * @ClassName : APIProcessLogFilter.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/18, frankchang
 *   1) First Release.
 */

package com.example.springboot.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.example.springboot.wrapper.WrapperHttpServletRequest;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;

@Order(0)
@Slf4j
@WebFilter(filterName = "APIProcessFilter", urlPatterns = "/*")
public class APIProcessLogFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		log.info("========== API start : get request ==========");
		
		// 紀錄 request 請求資訊
		String httpMethod = request.getMethod();
		String uri = request.getRequestURI();
		String params = request.getQueryString();
		if (params != null) {
			uri += "?" + params;
		}
		
		// 讀取出 request 參數
		WrapperHttpServletRequest servletRequest = new WrapperHttpServletRequest(request);
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(servletRequest);
		String requestBody = IOUtils.toString(requestWrapper.getInputStream(), StandardCharsets.UTF_8);
		String reqBody = requestBody.replaceAll("[\n\t]", "");
       
		log.info("httpMethod : {}, uri : {}, reqBody {}", httpMethod, uri, reqBody);
		
		filterChain.doFilter(servletRequest, response);
		
		log.info("========== API end : return response ==========");
		
	}
	

}
