/**
 * @Description : 簡單的 controller 操作
 * @ClassName : SimpleController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/07, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import java.nio.charset.Charset;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.api.response.SimpleResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@Tag(name = "簡單範例")
@Log4j2
@RequestMapping(value = "simple")
@Controller
public class SimpleController {

	@Operation(summary = "間單的 api")
	@GetMapping(value = "/get")
	public ResponseEntity<SimpleResponse> doGetRes(){
		
		SimpleResponse response = new SimpleResponse();
		
		log.info("執行 controller");
		log.info("目前系統預設語系: {}", Charset.defaultCharset());
		
		response.setReturnMsg("帥氣的法蘭克");
		
		return ResponseEntity.ok(response);
	}
}
