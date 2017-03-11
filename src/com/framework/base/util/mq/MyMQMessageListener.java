package com.framework.base.util.mq;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;

public class MyMQMessageListener {

	public void listenerMethod(Map messageMap){//
		System.out.println("MyMQMessageListener::name+发送线程"+(String)messageMap.get("name")+"接收线程::"+Thread.currentThread().getId());
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void listenerMethod(MapMessage messageMap){//
		try {
			System.out.println("MyMQMessageListener::MapMessagename+发送线程"+(String)messageMap.getString("name")+"接收线程::"+Thread.currentThread().getId());
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
