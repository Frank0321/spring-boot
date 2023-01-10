/**
 * @Description : TODO
 * @ClassName : FileService.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/09, Frank
 *   1) First Release.
 */

package com.example.springboot.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot.handler.ImageResourceHttpRequestHandler;

@Service
public class FileService {

	@Value("${user.file.path}")
	private String filePath;
	
	@Resource
    private ImageResourceHttpRequestHandler imageResourceHttpRequestHandler;
	
	/**
	 * @param multipartFile
	 * @return
	 */
	public String updateFile(MultipartFile multipartFile) {
		
		String returnMsg = "";
		
		try {
			// 新增時間戳在檔名上，表示唯一檔案
			File file = new File(filePath + "update.png");
			
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			String absolutePath = file.getAbsolutePath();
			
			File absoluteFile = new File(absolutePath);
			
			multipartFile.transferTo(absoluteFile);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		returnMsg = "上傳成功";
		
		return returnMsg;
	}

	/**
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateFile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		
        File file = new File(filePath + "update.png");
        httpServletRequest.setAttribute(ImageResourceHttpRequestHandler.ATTRIBUTE_FILE, file);
        imageResourceHttpRequestHandler.handleRequest(httpServletRequest, httpServletResponse);
		
	}

}
