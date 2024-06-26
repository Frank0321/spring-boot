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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String updateFile (@RequestParam("pic") MultipartFile multipartFile, @RequestParam("fileName") String fileName) {
		
		String returnMsg = service.updateFile(multipartFile, fileName);
		
		return returnMsg;
	}
	
	@GetMapping(value = "show")
	@ResponseBody
    public void download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
		
		service.showFile(httpServletRequest, httpServletResponse);
		
	}
	
	/***
	 * 將圖片轉換為 string
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value = "file2String")
	@ResponseBody
	public String file2String() throws IOException {
		
		String filtString = service.file2String();
		
		return filtString;
	}
	
	/***
	 * 將圖片轉換為 .gz 欓進行回傳
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value = "file2gz")
	public ResponseEntity<byte[]> file2gz() throws IOException {
		
		byte[] gzipBytes = service.file2gz();
		
		// 設定 header 與下載檔案名稱
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "pictureName.gz");
        headers.setContentLength(gzipBytes.length);
        
		return new ResponseEntity<>(gzipBytes, headers, HttpStatus.OK);
	}
	
	/***
	 * 將 string 轉換成 圖片  (待顯示方式)
	 * @param string
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 * @throws ServletException
	 */
	@PostMapping(value = "string2file")
	@ResponseBody
	public void String2file(@RequestBody String string, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
		
		service.string2File(string, httpServletRequest, httpServletResponse);
	}
	
}
