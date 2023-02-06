/**
 * @Description : 書本
 * @ClassName : BookEntity.java
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class BookEntity implements Serializable{
	
	private static final long serialVersionUID = -4749908967383924301L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "detail_id", referencedColumnName = "id")
	private BookDetailEntity bookDetail;
	
}
