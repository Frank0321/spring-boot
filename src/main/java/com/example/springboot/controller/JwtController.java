/**
 * @Description : jwt 測試 controller 
 * @ClassName : JwtController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/26, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.AuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.request.JwtRequest;
import com.example.springboot.api.response.JwtResponse;
import com.example.springboot.utils.JwtToken;

@RestController
@RequestMapping(value = "jwt")
public class JwtController {

	@Autowired
	private JwtToken jwtToken;
	
	@PostMapping(value = "createJwt")
	public JwtResponse create(@RequestBody JwtRequest request) {
		
		JwtResponse response = new JwtResponse();
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", request.getName());
		map.put("pwd", request.getPwd());
		
		String token = jwtToken.generateToken(map);
		response.setToken(token);
		
		return response;
		
	}
	
	@PostMapping(value = "validateToken")
	public ResponseEntity<JwtResponse> validate(@RequestBody JwtRequest request) {
		
		JwtResponse response = new JwtResponse();
		
		try {
			
			jwtToken.validateToken(request.getToken());
			response.setReturnMsg("validate success");
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (AuthException e) {
			
			response.setReturnMsg("validate fails");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
			
		}
		
	}
	
	/***
	 * 從 header 中取參數
	 * @param authorization
	 * @return
	 */
	@GetMapping(value = "getHeader")
	public ResponseEntity<JwtResponse> validate(@RequestHeader("Authorization") String authorization){
		
		JwtResponse response = new JwtResponse();
		
		String token = authorization.substring(6);
	
		try {
			
			jwtToken.validateToken(token);
			response.setReturnMsg("validate success");
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (AuthException e) {
			
			response.setReturnMsg("validate fails");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
			
		}
		
	}
}
