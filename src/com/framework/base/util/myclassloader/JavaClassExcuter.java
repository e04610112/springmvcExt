package com.framework.base.util.myclassloader;

import java.lang.reflect.Method;



public class JavaClassExcuter {
	/**
	 * 执行外部java类byte数组
	 * 将输入类的byte数组中代表java.lang.system的CONSTANT_Utf8_info常量修改为劫持后的hacksystem类
	 * 
	 */
	public static String execute(byte[] classByte){
		HackSystem.clearBuffer();
		ClassModifier cm=new ClassModifier(classByte);
		//byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System", "com/framework/base/util/myclassloader/HackSystem");
		byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System", "com/framework/base/util/myclassloader/HackSystem");
		HotSwapClassLoader loader=new HotSwapClassLoader();
		Class clazz=loader.loadByte(modiBytes);
		Method method;
		try {
			method = clazz.getMethod("main", new Class[]{String[].class});
			Object o=method.invoke(null, new String[]{null});
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace(HackSystem.out);
		} 
		return HackSystem.getBufferString();
	}
	/**
	 * 
	 * @param classByte
	 * @param args 第一个spring的beanID，第二个方法名，后面参数值
	 * @return
	 *@author lyj [Apr 20, 2015]
	 */
	public static String execute(byte[] classByte,Object[] args){
		HackSystem.clearBuffer();
		ClassModifier cm=new ClassModifier(classByte);
		//byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System", "com/framework/base/util/myclassloader/HackSystem");
		byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System", "com/framework/base/util/myclassloader/HackSystem");
		HotSwapClassLoader loader=new HotSwapClassLoader();
		Class clazz=loader.loadByte(modiBytes);
		Method method;
		try {
			method = clazz.getMethod("Test", new Class[]{Object[].class});
			Object o=method.invoke(clazz.newInstance(),new Object[]{args});
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace(HackSystem.out);
		} 
		return HackSystem.getBufferString();
	}
}
