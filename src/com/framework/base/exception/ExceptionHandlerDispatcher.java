package com.framework.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器的调度器
 * 
 */
class ExceptionHandlerDispatcher {

	private ExceptionHandler exceptionHandler;

	/**
	 * 调度对应的异常处理器
	 * 
	 */
	public ModelAndView dispatch(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {

		String requestType = request.getHeader(
				"X-Requested-With");

		if (requestType != null && "XMLHttpRequest".equals(requestType)) {
			//如果是Ajax请求，创建AjaxExceptionHandler这个异常处理器
			exceptionHandler = ExceptionHandlerFactory.getInstance("ajax");
			// 使用AjaxExceptionHandler异常处理器进行异常处理
			exceptionHandler.process(request,response,e);
			//Ajax请求，无需异常页面显示异常，返回null
			return null;
		} else {
			//如果是常规请求，创建NormalExceptionHandler这个异常处理器
			exceptionHandler = ExceptionHandlerFactory.getInstance("normal");
			// 使用NormalExceptionHandler异常处理器进行异常处理
			exceptionHandler.process(request,response,e);
			//常规请求，返回代表异常页面的字符串
			return new ModelAndView(ExceptionConfig.getParam("exception.page"));
		}

	}

}
