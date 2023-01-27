/**
 * @Description : 檔案管理 業務邏輯
 * @ClassName : FileService.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/09, Frank
 *   1) First Release.
 */

package com.example.springboot.service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.api.request.FileReqBody;
import com.example.springboot.handler.ImageResourceHttpRequestHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
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
	public String updateFile(MultipartFile multipartFile, String fileName) {
		
		String returnMsg = "";
		
		try {
			// 新增時間戳在檔名上，表示唯一檔案
			File file = new File(filePath + fileName + ".png");
			
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			String absolutePath = file.getAbsolutePath();
			
			File absoluteFile = new File(absolutePath);
			
			multipartFile.transferTo(absoluteFile);
			
		} catch (Exception e) {
			log.info("上傳失敗");
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
	public void showFile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		
        File file = new File(filePath + "update.png");
        httpServletRequest.setAttribute(ImageResourceHttpRequestHandler.ATTRIBUTE_FILE, file);
        imageResourceHttpRequestHandler.handleRequest(httpServletRequest, httpServletResponse);
		
	}

	/**
	 * 將圖片轉換成字串回傳
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String file2String() throws IOException {
		
		File file = new File(filePath + "update.png");
		byte[] fileContent = FileUtils.readFileToByteArray(file);
		String encodeToString = Base64.getEncoder().encodeToString(fileContent);
		
		return encodeToString;
	}


	/***
	 * 將文字轉換成圖片
	 * @param string
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 * @throws ServletException
	 */
	public void string2File(String string, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

		byte[] decode = Base64.getDecoder().decode(string);
		File outFile = new File(filePath + "show.png");
		FileUtils.writeByteArrayToFile(outFile, decode);
		
        httpServletRequest.setAttribute(ImageResourceHttpRequestHandler.ATTRIBUTE_FILE, outFile);
        imageResourceHttpRequestHandler.handleRequest(httpServletRequest, httpServletResponse);
	}

	/**
	 * @param reqBody
	 * @return
	 */
	public String updateFile(FileReqBody reqBody) {
		
		String returnMsg = "";
		String fileName = reqBody.getFileName();
		MultipartFile multipartFile = reqBody.getMultipartFile();
		
		try {
			// 新增時間戳在檔名上，表示唯一檔案
			File file = new File(filePath + fileName + ".png");
			
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			String absolutePath = file.getAbsolutePath();
			
			File absoluteFile = new File(absolutePath);
			
			multipartFile.transferTo(absoluteFile);
			
		} catch (Exception e) {
			log.info("上傳失敗");
		}
		
		returnMsg = "上傳成功";
		
		return returnMsg;
	}

}
