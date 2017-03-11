package com.framework.base.service.impl;

import com.framework.base.service.DubboService;

public class DubboServiceImpl implements DubboService {

	@Override
	public void sayHello() {
		System.out.println("dubbo:::::::   hello world!");  

	}

}
