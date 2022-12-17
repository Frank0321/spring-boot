/**
 * @Description : 員工功能業務邏輯
 * @ClassName : EmployService.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/05, frankchang
 *   1) First Release.
 *   2) 2022/12/11 新增單筆與多筆資料更新
 */

package com.example.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.api.request.EmployRequest;
import com.example.springboot.entity.EmployEntity;
import com.example.springboot.repository.EmployRepository;

@Service
public class EmployService {
	
	@Autowired
	private EmployRepository repository;

	/**
	 * 新增多筆資料
	 * 
	 * @param employList
	 */
	public void saveAll(List<EmployRequest> employList) {
		
		List<EmployEntity> employEntities = new ArrayList<EmployEntity>();
		
		for (EmployRequest employ : employList) {
			EmployEntity entity = new EmployEntity();
			entity.setEmpNo(employ.getEmpNo());
			entity.setName(employ.getName());
			entity.setCreateDate(employ.getCreateDate());
			entity.setPhone(employ.getPhone());
			entity.setMail(employ.getMail());
			employEntities.add(entity);
		}
		
		repository.saveAll(employEntities);
	}

	/**
	 * 新增一筆資料
	 * 
	 * @param request
	 * @return
	 */
	public String saveOne(EmployRequest request) {
		
		EmployEntity entity = new EmployEntity();
		entity.setEmpNo(request.getEmpNo());
		entity.setName(request.getName());
		entity.setCreateDate(new Date());
		entity.setPhone(request.getPhone());
		entity.setMail(request.getMail());
		repository.save(entity);
		
		return "success";
	}
	

}