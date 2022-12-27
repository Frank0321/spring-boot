/**
 * @Description : session 相關測試 req
 * @ClassName : SessionRequest.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/27, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SessionRequest implements Serializable {
	
	private static final long serialVersionUID = -1518769953664395890L;

	private Integer empId;
	
	private String name;
	
	private String phone;
}
