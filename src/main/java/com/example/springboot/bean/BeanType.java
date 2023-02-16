/**
 * @Description : Bean 的種類
 * @ClassName : BeanType.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/16, frankchang
 *   1) First Release.
 */

package com.example.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanType {
	
	@Bean
	@Scope(value = "singleton")
	public void singletonMethod() {
		
	}
	
	@Bean
	@Scope(value = "prototype")
	public void prototypeMethod() {
		
	}
	
	@Bean
	@Scope(value = "request")
	public void requestMethod() {
		
	}
	
	@Bean
	@Scope(value = "session")
	public void sessionMethod() {
		
	}
	
	@Bean
	@Scope(value = "application")
	public void applicationMethod() {
		
	}
	
	@Bean
	@Scope(value = "websocket")
	public void websocketMethod() {
		
	}

}
