/**
 * @Description : TODO
 * @ClassName : MainClass.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/09/04, frankchang
 *   1) First Release.
 */

package com.example.springboot.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainClass {

	public static void main(String[] args) {
		
		List<DataClass> loading = DataClass.Loading();
		
		List<ParentClass> list = new ArrayList<>();
		for (DataClass item : loading) {
			
			// 組合第二層的資料 (list)
			List<ChildClass> childList = new ArrayList<>();
			ChildClass child = new ChildClass();
			child.setId(item.getId());
			child.setName(item.getName());
			child.setAddress(item.getAddress());
			childList.add(child);
			
			ParentClass parent = new ParentClass();
			
			// 如果第一層的資料為空，則先 insert
			if (list.isEmpty()) {
				parent.setTerm(item.getTerm());
				parent.setNumber(item.getNumber());
				parent.setChildclassList(childList);
				list.add(parent);
			} else {
				// 使用 stream 判斷是否有資料的 term 與 loop 的一致
				Optional<ParentClass> optional = list.stream().filter(n -> n.getTerm().equals(item.getTerm())).findFirst();
				
				// 如果沒有一致，表示為新增一筆資料
				if (!optional.isPresent()) {
					parent.setTerm(item.getTerm());
					parent.setNumber(item.getNumber());
					parent.setChildclassList(childList);
					list.add(parent);
				// 否則將舊有的資料取出，並新增一筆資料進去	
				} else {
					parent = optional.get();
					List<ChildClass> childclassList = parent.getChildclassList();
					childclassList.addAll(childList);
					parent.setChildclassList(childclassList);
				}
				
			}
			
		}
		
		
		System.out.println("");
		
	}
	
	
}
