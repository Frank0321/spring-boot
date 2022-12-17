/**
 * @Description : 註冊為 Spring Bean 名稱時，第一個字母強制轉小寫
 * @ClassName : BeanNameGenerator.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/17, frankchang
 *   1) First Release.
 */

package com.example.springboot.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.ClassUtils;

public class BeanNameGenerator extends AnnotationBeanNameGenerator {

	@Override
	protected String buildDefaultBeanName(BeanDefinition definition) {
		
		String beanClassName = definition.getBeanClassName();
		
		// 不知道這幹蛤？ 
//		Assert.state(beanClassName != null, "No Bean class name set");
		
		String shortClassName = ClassUtils.getShortName(beanClassName);
		
		// 將第一個字母轉成小寫
		return StringUtils.uncapitalize(shortClassName);
	}
	
	

}
