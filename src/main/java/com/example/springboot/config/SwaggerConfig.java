/**
 * @Description : Swagger UI Configuration
 * @ClassName : SwaggerConfig.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/18, frankchang
 *   1) First Release.
 */

package com.example.springboot.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	/***
	 * 顯示全部的 api
	 * @return
	 */
	@Bean
	public GroupedOpenApi totalGroup() {
		return  GroupedOpenApi.builder()
				.group("openAPI")
				.pathsToMatch("/**")
				.build();
	}
	
	/***
	 * 顯示分類部分
	 * @return
	 */
	@Bean
	public GroupedOpenApi managerGroup() {
		return  GroupedOpenApi.builder()
				.group("簡單 api 範例")
				.pathsToMatch("/simple/**")
				.build();
	}
	

	
}
