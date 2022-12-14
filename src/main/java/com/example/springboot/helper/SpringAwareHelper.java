/**
 * @Description : 取得 spring pool 中 bean 的實例
 * @ClassName : SpringAwareHelper.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/14, frankchang
 *   1) First Release.
 */

package com.example.springboot.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringAwareHelper implements ApplicationContextAware {

	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	/**
	 * 依據 Bean name 取得 Instance
	 * 
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return context.getBean(name);
	}
	
	/**
	 * 依據 Interface 取得 Instance
	 * 
	 * @param <T>
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType){
		return context.getBean(requiredType);
	}
}
