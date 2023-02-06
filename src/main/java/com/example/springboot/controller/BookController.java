/**
 * @Description : 課本 入口點
 * @ClassName : BookController.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/06, frankchang
 *   1) First Release.
 */

package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.request.BookReqBody;
import com.example.springboot.entity.BookDetailEntity;
import com.example.springboot.entity.BookEntity;
import com.example.springboot.repository.BookDetailRepository;
import com.example.springboot.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookDetailRepository bookDetailRepository;
	
	@PostMapping(value = "create")
	public String create(@RequestBody BookReqBody reqBody) {
		
		BookDetailEntity detailEntity = new BookDetailEntity();
		detailEntity.setAuthor(reqBody.getAuthor());
		detailEntity.setPage(reqBody.getPage());
		bookDetailRepository.save(detailEntity);
		
		BookEntity bookEntity = new BookEntity();
		bookEntity.setName(reqBody.getName());
		bookEntity.setBookDetail(detailEntity);
		bookRepository.save(bookEntity);
		
		return "save";
	}

}
