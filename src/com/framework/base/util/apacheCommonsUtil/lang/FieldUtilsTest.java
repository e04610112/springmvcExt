package com.framework.base.util.apacheCommonsUtil.lang;

import org.apache.commons.lang.reflect.FieldUtils;



public class FieldUtilsTest {

	/**
	 * @param args
	 *@author lyj [May 26, 2015]
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException {
				Test test = new Test("Ray", "publicRay");    
		    
		        // 以下两个方法完全一样,都能获取共有或私有变量,因为第三个参数都设置了不检查    
		        FieldUtils.getDeclaredField(Test.class, "userName", true);    
		        FieldUtils.getField(Test.class, "userName", true);    
		    
		        // 读取私有或公共变量的值    
		        FieldUtils.readField(test, "userName", true);    
		        System.out.println(FieldUtils.readField(test, "userName", true));
		        // 读取静态变量    
		        FieldUtils.readStaticField(Test.class, "STATIC_FIELD");    
		        System.out.println(FieldUtils.readStaticField(Test.class, "STATIC_FIELD"));
		        // 写入私有或共有变量    
		        FieldUtils.writeField(test, "userName", "RayRay", true);    
		    
		       // 写入静态变量    
		        FieldUtils.writeStaticField(Test.class, "STATIC_FIELD", "static_value");    


	}

}
