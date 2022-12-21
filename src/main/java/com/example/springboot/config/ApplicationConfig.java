/**
 * @Description : 讀取 application 參數
 * @ClassName : ApplicationConfig.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/21, frankchang
 *   1) First Release.
 */

package com.example.springboot.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "application.param")
public class ApplicationConfig {
	
	private ConfigObject config;
	
	private List<ConfigUser> users;
	
	@Data
	public static class ConfigObject {

		private Long id;
		
		private String name;
		
		private String param;
	
	}
	
	@Data
	public static class ConfigUser {
		
		private String name;
		
		private String password;
	}
}
