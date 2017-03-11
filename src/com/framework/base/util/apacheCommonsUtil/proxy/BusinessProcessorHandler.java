package com.framework.base.util.apacheCommonsUtil.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BusinessProcessorHandler implements InvocationHandler{
	private Object target =null;
	public BusinessProcessorHandler(Object target) {
        this.target =target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		 System.out.println("在执行你的逻辑模块之 前，随便做点什么吧。");
		 Object result =method.invoke(target, args);
		 System.out.println("在执行你的逻辑模块之 后，做点想做的事情吧。");
		 return result;
	}

}
