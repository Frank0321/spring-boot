/**
 * @Description : 員工 res
 * @ClassName : EmployResponse.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/05, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployResponse implements Serializable {
	
	private static final long serialVersionUID = 8228422268357129372L;
	
	/** id */
	private String id;

	/** 名稱 */
	private String name;
}
