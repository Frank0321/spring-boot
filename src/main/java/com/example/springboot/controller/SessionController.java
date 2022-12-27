/**
 * @Description : session 相關測試的 controller
 * @ClassName : SessionController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/27, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.request.SessionRequest;
import com.example.springboot.api.response.SessionResponse;
import com.example.springboot.helper.httpHelper;
import com.example.springboot.user.LoginUser;

@RestController
@RequestMapping(value = "session")
public class SessionController {
	
	@Autowired
	private httpHelper helper;

	/***
	 * 登入時，將資訊存入 session
	 * @param request
	 * @return
	 */
	@PostMapping(value = "login")
	public SessionResponse login (@RequestBody SessionRequest request) {
		
		SessionResponse response = new SessionResponse();
		
		LoginUser loginUser = new LoginUser();
		loginUser.setName(request.getName());
		loginUser.setPhone(request.getPhone());
		loginUser.setEmpId(request.getEmpId());
		
		HttpSession session = this.helper.getSession();
		session.setAttribute("loginUser", loginUser);
		
		response.setReturnMsg("login finish");
		return response;
	}
	
	/***
	 * 將資料從 session 取出
	 * @return
	 */
	@GetMapping(value = "doing")
	public SessionResponse doing() {
		
		SessionResponse response = new SessionResponse();
		
		HttpSession session = this.helper.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
		
		if (loginUser != null) {
			response.setName(loginUser.getName());
			response.setPhone(loginUser.getPhone());
			response.setEmpId(loginUser.getEmpId());
		} else {
			response.setReturnMsg("loginUser is null");
		}
		
		return response;
	}
	
	/***
	 * 登出時，清除 session 資料
	 * @return
	 */
	@GetMapping(value = "logout")
	public SessionResponse logout() {
		
		SessionResponse response = new SessionResponse();
		
		HttpSession session = this.helper.getSession();
		if (session != null) {
			session.invalidate();
		}
		
		response.setReturnMsg("session logOut! session is clean");
		return response;
	}
}
