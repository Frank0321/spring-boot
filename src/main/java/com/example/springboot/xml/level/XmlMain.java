/**
 * @Description : xml 主程式
 * @ClassName : XmlMain.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/04/12, frankchang
 *   1) First Release.
 */

package com.example.springboot.xml.level;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlMain {

	public static void main(String[] args) {
		
		XmlBean xmlBean = new XmlBean();
		xmlBean.first = "first";
		xmlBean.firstName = "name";
		
		SubXmlBean subXmlBean = new SubXmlBean();
		subXmlBean.secound = "2";
		subXmlBean.secoundName = "2name";
		
		xmlBean.subXmlBean = subXmlBean;
		
		try {
			
			// sol(1)
//			JAXBContext context = JAXBContext.newInstance(XmlBean.class);
//			Marshaller marshaller = context.createMarshaller();
//			marshaller.marshal(xmlBean, System.out);
			
			// sol(2)
			JAXBContext context = JAXBContext.newInstance(XmlBean.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter writer = new StringWriter();
			marshaller.marshal(xmlBean, writer);
			String xmlString = writer.toString();
			
			System.out.println(xmlString);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}
}
