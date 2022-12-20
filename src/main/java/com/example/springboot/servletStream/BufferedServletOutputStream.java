/**
 * @Description : 重新定義 ServletOutputStream
 * @ClassName : WapperedOutputStream.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/19, frankchang
 *   1) First Release.
 */

package com.example.springboot.servletStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class BufferedServletOutputStream extends ServletOutputStream {
	
	private ByteArrayOutputStream baos;

	/**
	 * @param baos
	 */
	public BufferedServletOutputStream(ByteArrayOutputStream baos) {
		this.baos = baos;
	}

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public void setWriteListener(WriteListener listener) {
		
	}

	@Override
	public void write(int b) throws IOException {
		this.baos.write(b);
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		this.baos.write(b, 0, b.length);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		this.baos.write(b, off, len);
	}
	
	

}
