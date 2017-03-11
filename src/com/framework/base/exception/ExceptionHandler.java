package com.framework.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 异常处理器基类
 * @author zhutx [Aug 18, 2012]
 */
abstract class ExceptionHandler {
	
	public static final Logger logger = Logger.getLogger(ExceptionHandler.class); 
	
	/**
	 * 处理异常
	 */
	public abstract void process(HttpServletRequest request,
			HttpServletResponse response,Exception e);
	
	/**
	 * 封装异常Bean
	 */
	public ErrorBean makeErrorBean(Exception e){
		AppException appException = null;
		ErrorBean errorBean = null;
		try {
			appException = (AppException)e;
			errorBean = ExceptionLoader.getErrorBean(appException.getErrorCode());
			if(!StringUtils.isBlank(appException.getMyCause())){
				errorBean.setCause(appException.getMyCause());
			}
		} catch (RuntimeException e1) {
			errorBean = ExceptionLoader.getErrorBean("999999");
		}
		
		return errorBean;
	}

}
