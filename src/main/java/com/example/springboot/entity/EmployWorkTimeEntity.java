/**
 * @Description : 員工的工作時數 Ｅntity
 * @ClassName : EmployWorkTimeEntity.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/23, frankchang
 *   1) First Release.
 */

package com.example.springboot.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class EmployWorkTimeEntity {

	@Id
	private Integer id;
	
	/** 員工資料 id */
	private Long empId;
	
	/** 日期 */
	private Date dateTime;
	
	/** 上班時間 */
	private LocalDateTime startTime;
	
	/** 下班時間 */
	private LocalDateTime endTime;
}
