/**
 * @Description : TODO
 * @ClassName : FileReqBody.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/28, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileReqBody {

	private MultipartFile multipartFile;
	
	private String fileName;
}
