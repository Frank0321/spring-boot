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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileService {

	@Value("${user.file.path}")
	private String filePath;
	
	/**
	 * @param multipartFile
	 * @return
	 */
	public ModelAndView updateFile(MultipartFile multipartFile) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		
		try {
			File file = new File(filePath + multipartFile.getOriginalFilename());
			
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			
			multipartFile.transferTo(file);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}

}
