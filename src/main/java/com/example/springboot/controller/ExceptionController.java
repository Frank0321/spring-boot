/**
 * @Description : Exception Controller
 * @ClassName : ExceptionController.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/25, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.exception.DBException;

@RestController
@RequestMapping(value = "exception")
public class ExceptionController {
	
	@GetMapping(value = "npe")
	public String NullPointException() {
		
		throw new NullPointerException("此數為空值");
	}

	@GetMapping(value = "db")
	public  String dbException() throws DBException {
		
		String s = "sql 語法錯誤";
		throw new DBException(s);
	}
}
