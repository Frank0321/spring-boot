/**
 * @Description : 產生 xml 輸出樣式
 * @ClassName : XmlMainClass.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/04/20, frankchang
 *   1) First Release.
 */

package com.example.springboot.xml.simple;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

public class XmlMainClass {
	
	public static void main(String[] args) throws Exception{
		
		// 創建一個XmlObject對象
	    XmlObject xml = XmlObject.Factory.newInstance();
	    
	    // 創建一個根元素
	    XmlCursor cursor = xml.newCursor();
	    
	    cursor.toNextToken();
	    cursor.beginElement("SCSBML");
	    
	    
	    // 設置根元素的命名空間	
//	    cursor.insertAttributeWithValue(new QName("xmlnss"), "http://www.yahoo.com.tw");
	  
	    cursor.prefixForNamespace("http://www.abcd.com.tw");
//	    cursor.insertAttributeWithValue("xmlns", "http://www.scsb.com.tw");
//	    cursor.insertNamespace("aa", "http://www.scsb.com.tw");
//	    cursor.getAllNamespaces(Collections.singletonMap("", "http://www.scsb.com.tw"));
	    
	    // 添加第一層子元素 (HEAD)
	    cursor.beginElement("HEAD");
	    cursor.insertElementWithText("TXCODE", "EWB1657");
		cursor.insertElementWithText("TXDATE", "2023-04-06T18:28:58.056");
		cursor.insertElementWithText("TXSERIAL", "1680776938056");
		cursor.toEndToken();
		// 結束第一層子元素
	    
	    // 移動到下一層子元素
	    cursor.toNextToken();
	    
	    // 添加第二層子元素 (BODY)
	    cursor.beginElement("BODY");
	    cursor.beginElement("EWB1657");
	    cursor.beginElement("EWB1657RQ");
	    cursor.insertElementWithText("acn", "31191000228843"); //上行打電文需要的參數
	    cursor.insertElementWithText("aaa", "31191000228843"); //上行打電文需要的參數	    
	    cursor.toEndToken();
	    // 結束第二層子元素
	    
	    // 釋放游標資源
	    cursor.dispose();
	    
	    // 序列化XmlObject到XML格式
	    XmlOptions options = new XmlOptions();
	    options.setSavePrettyPrint();
//	    options.setSaveSuggestedPrefixes(Collections.singletonMap("http://www.scsb.com.tw", ""));
	    options.setSaveAggressiveNamespaces();
	    xml.save(System.out, options);	    
		
	}

}
