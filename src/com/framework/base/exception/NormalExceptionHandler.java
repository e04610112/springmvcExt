package com.framework.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 常规请求的异常处理器
 */
class NormalExceptionHandler extends ExceptionHandler {
	
	/**
	 * 处理常规请求调用异常
	 */
	public void process(HttpServletRequest request,
			HttpServletResponse response,Exception e){
		
		//创建异常Bean
		ErrorBean errorBean = this.makeErrorBean(e);
		
		//将异常Bean设置到request域里
		request.setAttribute("error",errorBean);
		//记录异常日志
		this.log(request,e);
	}
	
	/**
	 * 记录日志
	 */
	public void log(HttpServletRequest request,Exception e){
    	logger.error(request.getRequestURI()+ "请求发生错误:",e); 
    }
	
}
