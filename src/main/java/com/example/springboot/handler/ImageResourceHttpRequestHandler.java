/**
 * @Description : 上傳圖片 handler
 * @ClassName : ImageResourceHttpRequestHandler.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/10, frankchang
 *   1) First Release.
 */

package com.example.springboot.handler;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Component
public class ImageResourceHttpRequestHandler extends ResourceHttpRequestHandler {

    public static final String ATTRIBUTE_FILE = "DOWNLOADING_FILE";

	@Override
	protected Resource getResource(HttpServletRequest request) throws IOException {
      File file = (File) request.getAttribute(ATTRIBUTE_FILE);
      return new FileSystemResource(file);
	}
    
}
