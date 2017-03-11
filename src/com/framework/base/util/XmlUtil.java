package com.framework.base.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {
	  public static void main(String[] args) throws Exception  
	      {  
//	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
//	         DocumentBuilder db = dbf.newDocumentBuilder();  
//	            
//	          Document doc = db.parse(new File("d:/web.xml"));  
	          // step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）  
	               DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	                    
	          //      System.out.println("class name: " + dbf.getClass().getName());  
	                    
	                  // step 2:获得具体的dom解析器  
	                  DocumentBuilder db = dbf.newDocumentBuilder();  
	                   
	          //      System.out.println("class name: " + db.getClass().getName());  
	                    
	                  // step3: 解析一个xml文档，获得Document对象（根结点）  
	                 Document document = db.parse(new File("d:/web.xml"));  
	                    
	                  NodeList list = document.getElementsByTagName("web-app");  
	                   
	                  for(int i = 0; i < list.getLength(); i++)  
	                  {  
	                     Element element = (Element)list.item(i);  
	                       
	                    // String content = element.getElementsByTagName("listener").item(0).getFirstChild().getNodeValue();  
	                     String content = element.getElementsByTagName("listener").item(0).getTextContent();
	                     System.out.println("name:" + content);  
	                       
	                   
	                        
	                      System.out.println("--------------------------------------");  
	                  }  
	            }  

}
