/**
 * @Description : 員工功能業務邏輯
 * @ClassName : EmployService.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/05, frankchang
 *   1) First Release.
 *   2) 2022/12/11 新增單筆與多筆資料更新
 *   3) 2022/12/19 新增查詢全部功能
 */

package com.example.springboot.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.api.request.EmployRequest;
import com.example.springboot.api.response.EmployResponse;
import com.example.springboot.api.response.EmployResponse.DataModel;
import com.example.springboot.entity.EmployEntity;
import com.example.springboot.entity.EmployWorkTimeEntity;
import com.example.springboot.repository.EmployRepository;
import com.example.springboot.repository.EmployWorkTimeRepository;

@Service
public class EmployService {
	
	@Autowired
	private EmployRepository employRepository;

	@Autowired
	private EmployWorkTimeRepository employWorkTimeRepository;
	
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
		
		employRepository.saveAll(employEntities);
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
		employRepository.save(entity);
		
		return "success";
	}

	/**
	 * 查詢全部資料
	 * 
	 * @return
	 */
	public EmployResponse findAll() {
		
		List<EmployEntity> entities = employRepository.findAll();
		
		List<DataModel> list = new ArrayList<DataModel>();
		for (EmployEntity entity : entities) {
			DataModel dataModel = new DataModel();
			dataModel.setEmpNo(entity.getEmpNo());
			dataModel.setName(entity.getName());
//			dataModel.setCreateDate(entity.getCreateDate());
			dataModel.setPhone(entity.getPhone());
			dataModel.setMail(entity.getMail());
			list.add(dataModel);
		}
		
		EmployResponse response = new EmployResponse();
		response.setDataModels(list);
		
		return response;
	}

	/**
	 * 查詢一筆資料
	 * @param id
	 * @return
	 */
	public EmployResponse findOne(Long id) {
		
		EmployResponse response = new EmployResponse();
		
		EmployEntity entity = employRepository.findById(id).orElse(null);
		
		if (entity == null) {
			String string = String.format("參數 %d 查無資料", id);
			throw new IllegalArgumentException(string);
		}
		
		
		BeanUtils.copyProperties(entity, response);
		
		return response;
	}

	/**
	 * 更新一筆資料
	 * 
	 * @param id
	 * @param request 
	 * @return
	 */
	public EmployResponse updateOne(Long id, EmployRequest request) {
		
		EmployResponse response = new EmployResponse();
		
		EmployEntity employEntity = employRepository.findById(id).orElse(null);
		
		if (employEntity == null) {
			response.setRtnMsg("此 id 找無資料");
			return response;
		}
		
		employEntity.setEmpNo(request.getEmpNo());
		employEntity.setName(request.getName());
		employEntity.setMail(request.getMail());
		employEntity.setPhone(request.getPhone());
		employRepository.save(employEntity);
		
		response.setRtnMsg("資料已更新");
		
		return response;
		
	}

	/**
	 * 刪除一筆資料
	 * 
	 * @param id
	 * @return
	 */
	public EmployResponse deleteOne(Long id) {
		
		EmployResponse response = new EmployResponse();
		
		employRepository.deleteById(id);
		response.setRtnMsg("已刪除一筆資料");
		
		return response;
	}
	
	/***
	 * 計算特定員工的工時
	 * @param empNo
	 * @return
	 */
	public int employMoney(String empNo) {
		
		int money = 0;
		
		// 尋找員工資料
		EmployEntity employEntity = employRepository.findByEmpNo(empNo).orElse(null);		
		
		if (employEntity == null) {
			return money;
		}
		
		int hour = 0;
		
		// 找尋該員工工時資料
		List<EmployWorkTimeEntity> employWorkTimeEntities = employWorkTimeRepository.findByEmpId(employEntity.getId());
		for (EmployWorkTimeEntity employWorkTimeEntity : employWorkTimeEntities) {
			Duration duration = Duration.between(employWorkTimeEntity.getStartTime(), employWorkTimeEntity.getEndTime());
			hour += duration.toHours();
		}
		
		// 計算薪資
		money = employEntity.getHourlyWage() * hour;
		
		return money;
	}
	
	/***
	 * 找尋多筆資料
	 * @return
	 */
	public EmployResponse findList(List<String> list){
		
		EmployResponse response = new EmployResponse();
		
		List<EmployEntity> entities = employRepository.findList(list);
		
		List<DataModel> dataModels = new ArrayList<DataModel>();
		for (EmployEntity entity : entities) {
			DataModel dataModel = new DataModel();
			dataModel.setEmpNo(entity.getEmpNo());
			dataModel.setName(entity.getName());
			dataModel.setPhone(entity.getPhone());
			dataModel.setMail(entity.getMail());
			dataModels.add(dataModel);
		}
		
		response.setDataModels(dataModels);
		
		return response;
	}

}
