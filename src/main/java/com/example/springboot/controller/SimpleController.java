/**
 * @Description : 簡單的 controller 操作
 * @ClassName : SimpleController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/07, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping(value = "/get")
	public ResponseEntity<String> doGetRes(){
		return ResponseEntity.ok("帥氣的法蘭克");
	}
}
