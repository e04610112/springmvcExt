package com.framework.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class BaseController {
	
	
	
	public void responseJson(Object obj,HttpServletResponse response){
		Gson gson = new Gson();
		String result = "";
		if(null != obj)
			result = gson.toJson(obj);

		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			
		} finally{
			out.flush();
			out.close();
		}
	}
	
	public void responseJson(String jsonStr,HttpServletResponse response){

		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(jsonStr);
		} catch (IOException e) {
			
		} finally{
			out.flush();
			out.close();
		}
	}

}
