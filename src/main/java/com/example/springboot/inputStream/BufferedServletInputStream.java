/**
 * @Description : 重新定義 ServletInputStream，拷貝數據
 * @ClassName : BufferedServletInputStream.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/18, frankchang
 *   1) First Release.
 */

package com.example.springboot.inputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
            

public class BufferedServletInputStream extends ServletInputStream {
	
    private ByteArrayInputStream inputStream;

	/**
	 * 新增方法
	 * @param requestBody
	 */
	public BufferedServletInputStream(byte[] buffer) {
		this.inputStream = new ByteArrayInputStream(buffer);
		}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public void setReadListener(ReadListener listener) {

	}

	/***
	 * 改寫的部分
	 */
	@Override
	public int read() throws IOException {
		return inputStream.read();
	}

}
