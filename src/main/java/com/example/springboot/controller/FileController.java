/**
 * @Description : 檔案 上傳與顯示
 * @ClassName : FileController.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/09, Frank
 *   1) First Release.
 */

package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService service;
	
	@PostMapping(value = "upload")
	public ModelAndView updateFile (@RequestParam("pic") MultipartFile multipartFile) {
		
		ModelAndView modelAndView = service.updateFile(multipartFile);
		
		return modelAndView;
	}
	
//	@RequestMapping(value = "/{filename:.+}")
//	@ResponseBody
//	public ResponseEntity<?> getFile(@PathVariable String filename) {
//		try {
//			return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(filePath + filename)));
//		} catch (Exception e) {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	
}
