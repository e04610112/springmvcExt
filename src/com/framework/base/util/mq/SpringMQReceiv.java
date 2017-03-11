package com.framework.base.util.mq;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;

public class SpringMQReceiv {
	/**
	 * jmsTemplate还可设置消息转换器，直接转换成需要的java类，这里不谈论
	 */
	private JmsTemplate jmsTemplate;
	public void receiveMessage(){
		//同步方法，默认情况下会造成阻塞，可设置超时时间，也可主动设置目标
		MapMessage message=(MapMessage) jmsTemplate.receive();
		try {
			String nameString=message.getString("name");
			System.out.println(nameString);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
}
