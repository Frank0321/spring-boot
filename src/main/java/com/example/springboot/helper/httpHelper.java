/**
 * @Description : 取得 HTTP 相關資訊
 * @ClassName : httpHelper.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/27, frankchang
 *   1) First Release.
 */

package com.example.springboot.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class httpHelper {
	
	@Autowired
	private HttpServletRequest request;

	/**
	 * 取得當前 SESSION
	 * @return HttpSession
	 */
	public HttpSession getSession() {
	
		HttpSession session = this.request.getSession();
		
		return session;
	}
	
	

}
