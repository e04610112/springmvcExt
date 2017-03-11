package com.framework.base.util.apacheCommonsUtil.lang;

import org.apache.commons.lang.ClassUtils;

public class ClassUtilTest {

	/**
	 * @param args
	 *@author lyj [May 26, 2015]
	 */
	public static void main(String[] args) {
		 // 获取Test类所有实现的接口    
        ClassUtils.getAllInterfaces(Test.class);    
    
        // 获取Test类所有父类    
        ClassUtils.getAllSuperclasses(Test.class);    
    
        // 获取Test类所在的包名    
        ClassUtils.getPackageName(Test.class);    
    
        // 获取Test类简单类名    
        ClassUtils.getShortClassName(Test.class);    
    
        // 判断是否可以转型    
        ClassUtils.isAssignable(Test.class, Object.class);    
    
        // 判断是否有内部类    
        ClassUtils.isInnerClass(Test.class);    


	}

}
