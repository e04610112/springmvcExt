package com.framework.base.util.myclassloader;

public class HotSwapClassLoader extends ClassLoader{
	public HotSwapClassLoader(){
		//指定加载HotSwapClassLoader类的类加载器为父类加载器，这一步实现访问服务端类库
		super(HotSwapClassLoader.class.getClassLoader());
	}
	public Class loadByte(byte[] classByte){
		//将byte[]类型转换为class对象
		return defineClass(null, classByte, 0,classByte.length);
	}
}
