/**
 * @Description : 取得 application 參數 入口點
 * @ClassName : GetValueController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/21, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.response.GetValueResponse;
import com.example.springboot.service.GetValueService;

@RestController
@RequestMapping(value = "getValue")
public class GetValueController {
	
	@Autowired
	private GetValueService service;

	@GetMapping(value = "string")
	public String getString () {
		String response = service.getString();
		return response;
	}
	
	@GetMapping(value = "object")
	public GetValueResponse getResponse() {
		GetValueResponse response = service.getValueResponse();
		return response;
	}
	
}
