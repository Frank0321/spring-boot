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

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebFilter(filterName = "simpleFilter", urlPatterns = "/simple/*")
public class APITransferFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		log.info("before filter");
		
		chain.doFilter(request, response);
		
		log.info("after filter");
		
	}

}
