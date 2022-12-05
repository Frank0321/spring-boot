/**
 * @Description : 員工 api 入口點
 * @ClassName : EmployController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/05, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot.api.response.EmployResponse;
import com.example.springboot.service.EmployService;

@Controller
@ResponseBody
public class EmployController {
	
	@Autowired
	private EmployService service;
	
	@GetMapping(value = "all")
	public EmployResponse getAll () {
		
		EmployResponse response = new EmployResponse();
		
		return response;
	}

}
