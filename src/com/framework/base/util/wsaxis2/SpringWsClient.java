package com.framework.base.util.wsaxis2;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SpringWsClient {

	/**
	 * @param args
	 *@author lyj [May 19, 2015]
	 */
	public static void main(String[] args) {
		RPCServiceClient serviceClient = null;
		try {
		serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		       EndpointReference targetEPR = new EndpointReference("http://localhost:8080/springmvcExt/services/SpringWsService");
		       options.setTo(targetEPR);
		       
		       Object[] opAddEntryArgs = new Object[]{"CSZJFX"};
		       Class[] classes = new Class[]{String.class};
		       
		       //下面的代码调用了getXmlData方法，并返回一个XML格式的字符串
		       QName opAddEntry = new QName("http://192.168.36.149/services", "getXmlData");
		       String strXml = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
		       System.out.println("return:::::::"+strXml);
		       
//		       Document document = DocumentHelper.parseText(strXml);
//		       Element rootElm = document.getRootElement();
//		       StringBuffer sb = new StringBuffer();
//		       for(Iterator iter = rootElm.elementIterator(); iter.hasNext();){
//		                Element element = (Element) iter.next();
//		                System.out.println(element.getText());
//		            }


	}catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();

	}
	}
}
