package com.framework.base.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sun.org.apache.bcel.internal.generic.NEW;



public class MyProxyTest {
	interface IHello{
		void sayHello();
	}
	static class Hello implements IHello{
		@Override
		public void sayHello() {
			System.out.println("HELLO WORLD");
		}
	}
	static class MyProxy implements InvocationHandler{
		Object originalObj;
		Object bind(Object originalObj){
			this.originalObj=originalObj;
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}
		
	}
	/**
	 * @param args
	 *@author lyj [Apr 21, 2015]
	 */
	public static void main(String[] args) {
		IHello iHello=(IHello)new MyProxy().bind(new Hello());
		iHello.sayHello();

	}

}
