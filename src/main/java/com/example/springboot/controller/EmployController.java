/**
 * @Description : 員工 api 入口點
 * @ClassName : EmployController.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/05, frankchang
 *   1) First Release.
 *   2) 2022/12/11 新增單筆與多筆資料更新
 *   3) 2022/12/19 新增查詢全部功能
 */

package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.api.request.EmployRequest;
import com.example.springboot.api.response.EmployResponse;
import com.example.springboot.service.EmployService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping(value = "employ")
public class EmployController {
	
	@Autowired
	private EmployService service;
	
	/**
	 * 匯入基本資料 (批次儲存)
	 */
	@PostConstruct
	public void init() {
		
		List<EmployRequest> employList = new ArrayList<EmployRequest>();
		
		EmployRequest Frank = new EmployRequest();
		Frank.setEmpNo("2202475");
		Frank.setName("Frank");
		Frank.setCreateDate(null);   //待設定特定時間
		Frank.setPhone("0912456378");
		Frank.setMail("email@email");
		employList.add(Frank);
		
		service.saveAll(employList);
	}
	
	
	/**
	 * 查詢全部員工資料 (get)
	 */
	@GetMapping(value = "all")
	public ResponseEntity<EmployResponse> findAll(){
		
		EmployResponse response = service.findAll();
		
		log.info("finish");
		
		return ResponseEntity.ok(response);
	}
	
	
	/**
	 * 查詢特定員編的員工資料 (get)
	 */
	@GetMapping(value = "{id}")
	public ResponseEntity<EmployResponse> findOne(@PathVariable("id")Long id){
		
		EmployResponse response = new EmployResponse();
		response = service.findOne(id);
		return ResponseEntity.ok(response);
		
	}

	/**
	 * 新增一筆員工資料 (post)
	 */
	@PostMapping(value = "create")
	public ResponseEntity<String> createNewOne(@RequestBody EmployRequest request) {
		
		String saveOne = service.saveOne(request);
		
		return ResponseEntity.ok(saveOne);
	}
	
	/**
	 * 更新一筆員工資料 (put)
	 */
	@PutMapping(value = "{id}")
	public ResponseEntity<EmployResponse> updateOne(@PathVariable("id")Long id, @RequestBody EmployRequest request){
		
		EmployResponse response = new EmployResponse();
		response = service.updateOne(id, request);
		return ResponseEntity.ok(response);
		
	}
	
	/**
	 * 刪除一筆員工資料 (delete)
	 */
	@DeleteMapping(value = "{id}")
	public ResponseEntity<EmployResponse> deleteOne(@PathVariable("id")Long id){
		
		EmployResponse response = new EmployResponse();
		response = service.deleteOne(id);
		return ResponseEntity.ok(response);
	}
	
	
}
