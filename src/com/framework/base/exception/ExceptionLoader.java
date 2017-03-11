package com.framework.base.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

@SuppressWarnings("unchecked")
public class ExceptionLoader {

	private static Map<String,ErrorBean> EXCEPTION_MAP = new HashMap<String, ErrorBean>();
	
	static {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(ExceptionLoader.class.getResource("/com/framework/config/") + "exceptionConfig.xml");
			List<Element> exceptions = doc.getRootElement().getChildren("exception");
			for(Element el : exceptions){
				String errorCode = el.getAttributeValue("errorCode");
				ErrorBean errorBean = new ErrorBean();
				errorBean.setErrorCode(errorCode);
				errorBean.setLevel(el.getChildText("level"));
				errorBean.setMessage(el.getChildText("message"));
				errorBean.setCause(el.getChildText("cause"));
				errorBean.setMoveTo(el.getChildText("moveTo"));
				EXCEPTION_MAP.put(errorCode,errorBean);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ErrorBean getErrorBean(String errorCode) {
		return EXCEPTION_MAP.get(errorCode);
	}

}
