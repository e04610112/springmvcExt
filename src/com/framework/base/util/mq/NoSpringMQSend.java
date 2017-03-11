package com.framework.base.util.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class NoSpringMQSend {

	/**
	 * @param args
	 *@author lyj [May 20, 2015]
	 */
	public static void main(String[] args) {
		ConnectionFactory cFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		// 设置用户名和密码，这个用户名和密码在conf目录下的credentials.properties文件中，也可以在activemq.xml中配置
		//((ActiveMQConnectionFactory) cFactory).setUserName("system");
		//((ActiveMQConnectionFactory) cFactory).setPassword("manager");
		Connection conn=null;
		Session session=null;
		try {
			conn=cFactory.createConnection();//创建连接
			// 创建Session，参数解释：
            // 第一个参数是否使用事务:当消息发送者向消息提供者（即消息代理）发送消息时，消息发送者等待消息代理的确认，没有回应则抛出异常，消息发送程序负责处理这个错误。
            // 第二个参数消息的确认模式：
            // AUTO_ACKNOWLEDGE ： 指定消息提供者在每次收到消息时自动发送确认。消息只向目标发送一次，但传输过程中可能因为错误而丢失消息。
            // CLIENT_ACKNOWLEDGE ： 由消息接收者确认收到消息，通过调用消息的acknowledge()方法（会通知消息提供者收到了消息）
            // DUPS_OK_ACKNOWLEDGE ： 指定消息提供者在消息接收者没有确认发送时重新发送消息（这种确认模式不在乎接收者收到重复的消息）。
			session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建会话
			Destination destination=new ActiveMQQueue("myQueue");//创建队列
			MessageProducer producer=session.createProducer(destination);
			// 设置持久化，DeliveryMode.PERSISTENT和DeliveryMode.NON_PERSISTENT
           // producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			TextMessage message=session.createTextMessage();
			message.setText("hello world");
			//producer.send(message);
			MapMessage mapMessage=session.createMapMessage();
			mapMessage.setString("name", "林");
			producer.send(mapMessage);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(session!=null)session.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
