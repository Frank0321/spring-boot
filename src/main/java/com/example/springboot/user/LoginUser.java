/**
 * @Description : 登入使用者
 * @ClassName : LoginUser.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/27, frankchang
 *   1) First Release.
 */

package com.example.springboot.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginUser implements Serializable {
	
	private static final long serialVersionUID = 4567343722290915249L;

	private Integer empId;
	
	private String name;
	
	private String phone;

}
