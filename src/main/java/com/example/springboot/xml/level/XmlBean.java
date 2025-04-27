/**
 * @Description : 第一層 xml
 * @ClassName : XmlBean.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/04/12, frankchang
 *   1) First Release.
 */

package com.example.springboot.xml.level;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class XmlBean {

	public String first;
	
	public String firstName;
	
	public SubXmlBean subXmlBean;
	
}
