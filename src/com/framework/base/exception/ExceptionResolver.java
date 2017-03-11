package com.framework.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

class ExceptionResolver implements HandlerExceptionResolver {
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		
		ExceptionHandlerDispatcher dispatcher = new ExceptionHandlerDispatcher();
		//调度器内部调用对应的异常处理器进行异常处理
		return dispatcher.dispatch(request,response,handler,e);
		
	}

}
