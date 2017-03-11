package com.framework.base.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Ajax请求的异常处理器
 */
class AjaxExceptionHandler extends ExceptionHandler {
	
	/**
	 * 处理Ajax请求调用异常
	 */
	public void process(HttpServletRequest request,
			HttpServletResponse response,Exception e){
		//创建异常Bean
		ErrorBean errorBean = this.makeErrorBean(e);//得到配置的异常信息，展示暂时未处理
		//推送到页面提示
		//this.reponse(this.toJson(errorBean),response);
		ExceptionReturn extReturnex= new ExceptionReturn(e);
		this.reponse(this.toJson(extReturnex),response);
		//记录异常日志
		this.log(request,e);
	}
	
	/**
	 * 记录日志
	 */
	public void log(HttpServletRequest request,Exception e){
    	logger.error(request.getRequestURI()+ "请求发生错误:",e); 
    }
	
	/**
	 * 对象转JSON串
	 */
	public String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	/**
	 * 将JSON串输出到页面
	 */
	public void reponse(String json,HttpServletResponse response){
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		//response.setStatus(500);

		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(json);

		out.flush();
		out.close();
	}
	
}
