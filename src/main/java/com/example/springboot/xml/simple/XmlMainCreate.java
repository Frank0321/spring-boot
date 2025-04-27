/**
 * @Description : 產生 xml 輸出樣式
 * @ClassName : XmlMainCreate.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/04/21, frankchang
 *   1) First Release.
 */

package com.example.springboot.xml.simple;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XmlMainCreate {
		
	public static void main(String[] args) throws Exception {
		
	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.newDocument();

      // Create root element
      Element rootElement = doc.createElement("SCSBML");
      doc.appendChild(rootElement);
      Attr attr = doc.createAttribute("xmlns");
      attr.setValue("http://www.scsb.com.tw");
      rootElement.setAttributeNode(attr);

      createHeader(doc, rootElement);

      createBody(doc, rootElement);

      output(doc);
	}

	/**
	 * @param doc
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	private static void output(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException
	{
		// Output the XML document
		  TransformerFactory transformerFactory = TransformerFactory.newInstance();
		  Transformer transformer = transformerFactory.newTransformer();
	      transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes"); // remove XML declaration
		  transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes"); // set indentation
		  transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // set indentation size
		  DOMSource source = new DOMSource(doc);

		  StringWriter writer = new StringWriter();
		  StreamResult result = new StreamResult(writer);

		  transformer.transform(source, result);

		  String xmlString = writer.toString();
		  System.out.println(xmlString);
	}

	/**
	 * 建立 body 內容
	 * 
	 * @param doc
	 * @param rootElement
	 */
	private static void createBody(Document doc, Element rootElement) {
		
		  // body 第一層
		  Element bodyElement = doc.createElement("BODY");
		  rootElement.appendChild(bodyElement);

		  // body 第二層
		  Element eWB1657eElement = doc.createElement("EWB1657");
		  bodyElement.appendChild(eWB1657eElement);
		  
		  // body 第三層-1
		  Element acnElement = doc.createElement("acn");
		  eWB1657eElement.appendChild(acnElement);
		  
		  // 第三層內容-1
		  Text child1Text = doc.createTextNode("31191000228843");
		  acnElement.appendChild(child1Text);
		  
		  // body 第三層-2
		  Element aaaElement = doc.createElement("aaa");
		  eWB1657eElement.appendChild(aaaElement);
		  
		  // 第三層內容-2
		  Text child2Text = doc.createTextNode("31191000228843");
		  aaaElement.appendChild(child2Text);

	}

	/**
	 * 建立 header 內容
	 * 
	 * @param doc
	 * @param rootElement
	 */
	private static void createHeader(Document doc, Element rootElement) {
		// Create first level element
		  Element headerElement = doc.createElement("HEAD");
		  rootElement.appendChild(headerElement);

		  // Create second level element
		  Element secondLevelElement = doc.createElement("TXCODE");
		  headerElement.appendChild(secondLevelElement);

		  // Create text node for second level element
		  Text text = doc.createTextNode("EWB1657");
		  secondLevelElement.appendChild(text);
	}

}
