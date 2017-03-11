package com.framework.base.util.apacheCommonsUtil.lang;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.MethodUtils;



public class MethodUtilTest {

	/**
	 * @param args
	 *@author lyj [May 26, 2015]
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		 // 调用无参方法    
		        Test test = new Test();    
		        MethodUtils.invokeMethod(test, "publicHello", null);    
		    
		        // 调用一参方法    
		        MethodUtils.invokeMethod(test, "publicHello", "Hello");    
		    
		        // 调用多参方法    
		        MethodUtils.invokeMethod(test, "publicHello", new Object[] { "100",    
		                new Integer(10) });    
		    
		        // 调用静态方法    
		        MethodUtils.invokeStaticMethod(Test.class, "staticHello", null);    


	}

}
