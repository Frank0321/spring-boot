/**
 * @Description : 實作 filter 功能
 * @ClassName : APITransferFilter.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/07, frankchang
 *   1) First Release.
 */

package com.example.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.springboot.wrapper.WrapperHttpServletRequest;
import com.example.springboot.wrapper.WrapperHttpServletResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebFilter(filterName = "simpleFilter", urlPatterns = "/simple/*")
public class APITransferFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		log.info("before filter");
		
		WrapperHttpServletRequest reqWrapper = new WrapperHttpServletRequest((HttpServletRequest) request);
		WrapperHttpServletResponse resWrapper = new WrapperHttpServletResponse((HttpServletResponse) response);
		resWrapper.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin");
		
		chain.doFilter(reqWrapper, resWrapper);
		
		// 改寫 response
		ObjectMapper mapper = new ObjectMapper();
		byte[] responseData = resWrapper.getResponseData();
		JsonNode resContent = mapper.readTree(new String(responseData, "UTF8"));
		
		ObjectNode node = mapper.createObjectNode();
		node.putPOJO("resHeader", "header");
		node.putPOJO("resBody", resContent);
		response.getWriter().write(mapper.writeValueAsString(node));
		
		log.info("after filter");
		
	}

}
