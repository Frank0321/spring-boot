/**
 * @Description : 取得 application 參數，轉換成 response
 * @ClassName : GetValueResponse.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/21, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.response;

import java.util.List;

import lombok.Data;

@Data
public class GetValueResponse {

	private Long id;
	
	private String name;
	
	private String param;
	
	private List<User> users;
	
	@Data
	public static class User {
		
		private String name;
		
		private String password;
	}
}
