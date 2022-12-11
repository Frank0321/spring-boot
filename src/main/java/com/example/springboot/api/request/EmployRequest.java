/**
 * @Description : 員工 req
 * @ClassName : EmployRequest.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/11, Frank
 *   1) First Release.
 */

package com.example.springboot.api.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EmployRequest implements Serializable {
	 
	private static final long serialVersionUID = 8130538164644354999L;
	
	/** 員工編號 */
	private String empNo;
	
	/** 員工姓名 */
	private String name;
	
	/** 到職日期 */
	private Date createDate;
	
	/** 連絡電話 */
	private String phone;
	
	/** email */
	private String mail;
	
}
