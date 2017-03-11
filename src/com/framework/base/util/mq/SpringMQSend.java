package com.framework.base.util.mq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringMQSend {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	public void sendMessageToMQ(){
		for(int i=0;i<100;i++){
			Thread thread=new Thread(new sendThread());
			thread.start();
		}
//		jmsTemplate.send(destination,new MessageCreator(){
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				MapMessage message=session.createMapMessage();
//				message.setString("name", "林"+session);
//				
//				return message;
//			}
//		});
		
	}
	class sendThread implements Runnable{

		@Override
		public void run() {
			jmsTemplate.send(destination,new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage message=session.createMapMessage();
					message.setString("name", "林"+"Thread::"+Thread.currentThread().getId());
					System.out.println("发送："+Thread.currentThread().getId());
					return message;
				}
			});
			
		}
		
	}
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}


	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
