/**
 * @Description : 檔案 上傳與顯示
 * @ClassName : FileController.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/09, Frank
 *   1) First Release.
 */

package com.example.springboot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService service;
	
	@PostMapping(value = "upload")
	@ResponseBody
	public String updateFile (@RequestParam("pic") MultipartFile multipartFile) {
		
		String returnMsg = service.updateFile(multipartFile);
		
		return returnMsg;
	}
	
	@GetMapping(value = "show")
	@ResponseBody
    public void download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
		
		service.updateFile(httpServletRequest, httpServletResponse);
		
	}
	
}
