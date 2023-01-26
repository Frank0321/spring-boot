/**
 * @Description : Exception handler
 * @ClassName : CatchExceptionHandler.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/25, frankchang
 *   1) First Release.
 */

package com.example.springboot.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springboot.exception.DBException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class CatchExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> npeHandler(NullPointerException e){
		
		log.info("我接住了 Exception");
		
		String string = e.getMessage();
		
		return ResponseEntity.ok(string);
	}
	
	@ExceptionHandler(DBException.class)
	public ResponseEntity<String> npeHandler(DBException e){
		
		log.info("我接住了 Exception");
		
		String string = e.getMessage();
		
		return ResponseEntity.ok(string);
	}
	
}
