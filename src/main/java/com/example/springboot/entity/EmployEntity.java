/**
 * @Description : 員工 Entity
 * @ClassName : EmployEntity.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/09, Frank
 *   1) First Release.
 */

package com.example.springboot.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class EmployEntity {
	
	@Id
	@GeneratedValue
	/** id */
	private long id;
	
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
