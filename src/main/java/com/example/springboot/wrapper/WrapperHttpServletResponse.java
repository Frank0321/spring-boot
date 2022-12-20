/**
 * @Description : 重新包裝 HttpServletResponse
 * @ClassName : WrapperHttpServletResponse.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/19, frankchang
 *   1) First Release.
 */

package com.example.springboot.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.example.springboot.servletStream.BufferedServletOutputStream;

public class WrapperHttpServletResponse extends HttpServletResponseWrapper {

	private ByteArrayOutputStream baos;
	private ServletOutputStream sot;
	private PrintWriter writer;
	
	/**
	 * @param response
	 * @throws IOException 
	 */
	public WrapperHttpServletResponse(HttpServletResponse response) throws IOException {
		
		super(response);
		
		this.baos = new ByteArrayOutputStream();
		this.sot = new BufferedServletOutputStream(this.baos);
		this.writer = new PrintWriter(new OutputStreamWriter(this.baos, this.getCharacterEncoding()));
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		
		return this.sot;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		
		return this.writer;
	}

	@Override
	public void flushBuffer() throws IOException {
		
		if (this.sot != null) {
			this.sot.flush();
		}
		
		if (this.writer != null) {
			this.writer.flush();
		}
	}

	@Override
	public void reset() {
		
		 this.baos.reset();
	}
	
	public byte[] getResponseData() throws IOException {
		return baos.toByteArray();
	}
	

}
