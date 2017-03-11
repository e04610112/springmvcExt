package com.framework.base.util.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class NoSpringMQAccept {

	/**
	 * @param args
	 *@author lyj [May 20, 2015]
	 */
	public static void main(String[] args) {
		ConnectionFactory cFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn=null;
		Session session=null;
		try {
			conn=cFactory.createConnection();
			session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建会话
			Destination destination=new ActiveMQQueue("myQueue");//创建队列
			MessageConsumer consumer=session.createConsumer(destination);
			conn.start();
			Message message=consumer.receive();
			MapMessage mapessage=(MapMessage)message;
			String nameString=mapessage.getString("name");
			System.out.println(nameString);
		} catch (Exception e) {
			// TODO: handle exception
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
