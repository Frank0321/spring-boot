/**
 * @Description : 書本詳細內容
 * @ClassName : BookDetail.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/06, frankchang
 *   1) First Release.
 */

package com.example.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bookDetail")
public class BookDetailEntity implements Serializable{

	private static final long serialVersionUID = -2198401260971611426L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String author;
	
	private Integer page;
}
