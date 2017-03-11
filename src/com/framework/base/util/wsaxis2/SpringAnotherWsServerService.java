package com.framework.base.util.wsaxis2;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.framework.base.service.BaseUsersService;

public class SpringAnotherWsServerService {
	//protected static final Log logger = LogFactory.getLog(SpringWsServerService.class);
	@Autowired
	private BaseUsersService baseUsersService;
	//@WebMethod
	public String getAnotherXmlData(String paramName) {
	String xmlStr = "";
	Map paramMap = new HashMap();
	try {
	//ReportPage pi = userService.query(paramMap);
	Document document = DocumentHelper.createDocument();
	//if(pi.getResult().size() > 0){
	//if(pi.getResult().size() == 1){
	Element root = document.addElement("datas");
	Element modulename = root.addElement("id").addText("1");
	Element paramName1 = root.addElement("username").addText("2");
	Element showName = root.addElement("password").addText("3");
	Element greenValue = root.addElement("birthday").addText("4");
	Element yellowValue = root.addElement("salery").addText("5");
	
	System.out.println(baseUsersService.countByExample(null));
	//}
//	else{
//	Element root = document.addElement("datas");
//	for(int i=0; i<pi.getResult().size(); i++){
//	Element leaf = root.addElement("data");
//	Element modulename = leaf.addElement("id").addText("6");
//	Element paramName1 = leaf.addElement("username").addText("6");
//	Element showName = leaf.addElement("password").addText("6");
//	Element greenValue = leaf.addElement("birthday").addText("6");
//	Element yellowValue = leaf.addElement("salery").addText("6");
//	}
//	}
	//}
	xmlStr = document.asXML();
	} catch (Exception e) {
	//logger.error(e.getMessage());
	e.printStackTrace();
	}
	return xmlStr;
	}

}
