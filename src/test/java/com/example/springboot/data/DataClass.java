/**
 * @Description : TODO
 * @ClassName : DataClass.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/09/04, frankchang
 *   1) First Release.
 */

package com.example.springboot.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataClass {

	private int id;
	
	private String name;
	
	private String address;
	
	private String term;
	
	private int number;
	
	public static List<DataClass> Loading() {
		
		List<DataClass> list = new ArrayList<>();
		
		for(int a = 0; a < 100; a ++ ) {
			
			int b = a%5;
			
			DataClass dataClass = new DataClass(a, ("name" + a), ("address"+a), ("000" + b), b);
			
			list.add(dataClass);
		}
		
		
		return list;
		
	}
	
}
