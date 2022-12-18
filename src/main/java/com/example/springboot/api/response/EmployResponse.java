/**
 * @Description : 員工 res
 * @ClassName : EmployResponse.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/05, frankchang
 *   1) First Release.
 *   2) 2022/12/19 新增 dataModel 資料結構
 */

package com.example.springboot.api.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class EmployResponse implements Serializable {
	
	private static final long serialVersionUID = 8228422268357129372L;
	
	/** id */
	private String id;

	/** 名稱 */
	private String name;
	
	/** dataModel */
	private List<DataModel> dataModels;
	
	@Data
	@JsonInclude(value = Include.NON_NULL)
	public static class DataModel {
		
		/** 員工編號 */
		private String empNo;
		
		/** 員工姓名 */
		private String name;
		
		/** 到職日期 */
		private String createDate;
		
		/** 連絡電話 */
		private String phone;
		
		/** email */
		private String mail;
	}
}
