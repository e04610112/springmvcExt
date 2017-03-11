package com.framework.base.util.myclassloader;

import java.lang.reflect.Method;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.framework.base.entity.BaseUsers;
import com.framework.base.service.LoginService;
import com.framework.base.util.MD5Util;

public class TessClass {

	/**
	 * @param args
	 *@author lyj [Apr 17, 2015]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BaseUsers baseUser=loginService.getBaseUserForLogin("zjhtdz",MD5Util.MD5("000000"));
		//System.out.println("LoginController测试类，远程"+baseUser.getAccount());
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
		LoginService loginService=(LoginService) wac.getBean("loginServiceImpl");  
		BaseUsers baseUser=loginService.getBaseUserForLogin("admin",MD5Util.MD5("000000"));
		System.out.println("TessClass，远程"+baseUser.getAccount());
		//HackSystem.out.println("TessClass，远程"+baseUser.getAccount());
		//HackSystem.out.println("TessClass，远程");
	}
	public void test(Object[] args){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		Object object= wac.getBean((String)args[0]); 
		Object[] argsOther=new Object[args.length-2];
		int len=argsOther.length;
		Class[] argsClass = new Class[len];   
		StringBuffer stringBuffer=new StringBuffer();
		for (int i=0;i<len;i++) {
			argsOther[i]=args[i+2];
			stringBuffer.append(args[i+2]);
			argsClass[i]=args[i+2].getClass();
		}
		try {
//			Method method = object.getClass().getMethod((String)args[1], new Class[]{String.class,String.class});
//			Object o=method.invoke(object, argsOther);
			Method method = object.getClass().getMethod((String)args[1], argsClass);
			Object o=method.invoke(object, argsOther);
			System.out.println("TessClass||"+(String)args[0]+"||"+(String)args[1]+"||"+stringBuffer.toString());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
