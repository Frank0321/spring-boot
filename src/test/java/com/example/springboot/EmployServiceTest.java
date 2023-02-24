/**
 * @Description : 員工功能的 unit test
 * @ClassName : EmployServiceTest.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/24, frankchang
 *   1) First Release.
 */

package com.example.springboot;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springboot.entity.EmployEntity;
import com.example.springboot.entity.EmployWorkTimeEntity;
import com.example.springboot.repository.EmployRepository;
import com.example.springboot.repository.EmployWorkTimeRepository;
import com.example.springboot.service.EmployService;

import junit.framework.Assert;

@ExtendWith(MockitoExtension.class)
public class EmployServiceTest {

	@Mock
	private EmployRepository employRepository;
	
	@Mock
	private EmployWorkTimeRepository employWorkTimeRepository;
	
	@InjectMocks
	private EmployService employService;
	
	@Test
	public void employMoneyCase1() {
		
		// 假設呼叫 mock 物件 (Dao) 會回傳的物件
		EmployEntity employEntity = new EmployEntity().setEmpNo("emp01")
						.setId(3)
						.setHourlyWage(10);
		
		List<EmployWorkTimeEntity> list = new ArrayList<EmployWorkTimeEntity>();
		list.add(EmployWorkTimeEntity.builder()
									.startTime(LocalDateTime.parse("2022-12-01T08:50:23"))
									.endTime(  LocalDateTime.parse("2022-12-01T18:00:00"))
									.build());
		list.add(EmployWorkTimeEntity.builder()
									.startTime(LocalDateTime.parse("2022-12-02T08:53:43"))
									.endTime(  LocalDateTime.parse("2022-12-02T20:11:10"))
									.build());
		
		// 當呼叫 mock 物件時，帶入的參數，與對應回傳的資料
		when(employRepository.findByEmpNo("emp01"))
				.thenReturn(Optional.of(employEntity));

		when(employWorkTimeRepository.findByEmpId(3)).thenReturn(list);
		
		// 實際執行該方法，所得到的結果
		int employMoney = employService.employMoney("emp01");
		
		// 驗證該方法是否符合預期的結果
		Assert.assertEquals(employMoney, 200);
		
	}
}
