/**
 * @Description : TODO
 * @ClassName : ParentClass.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/09/04, frankchang
 *   1) First Release.
 */

package com.example.springboot.data;

import java.util.List;

import lombok.Data;

@Data
public class ParentClass {

	private String term;
	
	private int number;
	
	private List<ChildClass> childclassList;
	
}
