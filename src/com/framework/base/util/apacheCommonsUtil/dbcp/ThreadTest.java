package com.framework.base.util.apacheCommonsUtil.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;

public class ThreadTest implements Runnable{


	@Override
	public void run() {
		System.out.println("Creating connection.");  
        Connection conn;
		try {
			for(int i=0;i<1000;i++){
				conn = DbcpConnect.getConnection();
				System.out.println("Creating statement.");  
		        PreparedStatement stmt = conn.prepareStatement("select * from sys_oper");  
		        System.out.println("Executing statement.");  
		        ResultSet rset = stmt.executeQuery();  
		        System.out.println("Results:");  
		        while(rset.next()) { 
		        	System.out.println(rset.getString("oper_id"));  
		            System.out.println(""); 
		        }
		        conn.close();//用完要关掉
			}
			
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
       
		
	}
	

}
