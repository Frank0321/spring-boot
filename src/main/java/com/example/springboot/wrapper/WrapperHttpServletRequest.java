/**
 * @Description : 重新包裝 HttpServletRequest，使得數據可以多次被讀取
 * @ClassName : WrapperHttpServletRequest.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/18, frankchang
 *   1) First Release.
 */

package com.example.springboot.wrapper;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

import com.example.springboot.inputStream.BufferedServletInputStream;

public class WrapperHttpServletRequest extends HttpServletRequestWrapper {
	
    private static byte[] requestBody;

	/**
	 * @param request
	 */
	public WrapperHttpServletRequest(HttpServletRequest request) {
		super(request);
		try {
			 requestBody = IOUtils.toByteArray(request.getInputStream());
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
	/***
	 * 將數據進行拷貝
	 */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        if(requestBody == null) {
            requestBody = new byte[0];
        }
        return new BufferedServletInputStream(requestBody);
    }

}
