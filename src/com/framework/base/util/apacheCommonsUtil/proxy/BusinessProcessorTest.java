package com.framework.base.util.apacheCommonsUtil.proxy;

import java.lang.reflect.Proxy;

public class BusinessProcessorTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 */
	public static void main(String[] args) {
		BusinessProcessor bpimpl = new BusinessProcessorImpl();

        BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);

        //这是动态代理的核心方法

        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(

                          bpimpl.getClass().getClassLoader(),bpimpl.getClass()

                                             .getInterfaces(),handler);

        bp.processBusiness();

	}

}
