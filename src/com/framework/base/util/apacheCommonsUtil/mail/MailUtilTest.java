package com.framework.base.util.apacheCommonsUtil.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtilTest {

	/**
	 * @param args
	 *@author lyj [May 26, 2015]
	 * @throws EmailException 
	 */
	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		Email email = new SimpleEmail();  
        email.setHostName("smtp.163.com");  
        email.setSmtpPort(125);  
        email.setAuthenticator(new DefaultAuthenticator("e04610112", "lyj6335473"));  
        email.setSSLOnConnect(true);  
        email.setFrom("e04610112@163.com");  
        email.setSubject("TestMail");  
        email.setMsg("This is a Test mail ... :-)");
        email.addTo("103860274@qq.com");  
        email.send();  

	}

}
