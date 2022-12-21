/**
 * @Description : 取得 application 參數 業務邏輯
 * @ClassName : GetValueService.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/21, frankchang
 *   1) First Release.
 */

package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.springboot.api.response.GetValueResponse;
import com.example.springboot.api.response.GetValueResponse.User;
import com.example.springboot.config.ApplicationConfig;
import com.example.springboot.config.ApplicationConfig.ConfigUser;

@Service
public class GetValueService {

	@Value("${application.param.value: param_value}")
	private String applicationValue;
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	/**
	 * @return
	 */
	public String getString() {
		
		return applicationValue;
	}

	/**
	 * @return
	 */
	public GetValueResponse getValueResponse() {
		
		// 讀取 object
		GetValueResponse response = new GetValueResponse();
		response.setId(this.applicationConfig.getConfig().getId());
		response.setName(this.applicationConfig.getConfig().getName());
		response.setParam(this.applicationConfig.getConfig().getParam());
		
		// 讀取 List<object>
		List<User> list = new ArrayList<User>();
		for (ConfigUser configUser : this.applicationConfig.getUsers()) {
			User user = new User();
			user.setName(configUser.getName());
			user.setPassword(configUser.getPassword());
			list.add(user);
		}
		response.setUsers(list);
		
		
		return response;
	}

}
