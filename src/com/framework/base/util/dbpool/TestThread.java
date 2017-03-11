package com.framework.base.util.dbpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestThread implements Runnable {
	
	@Override
	public void run() {
		Connection  con=DBUtil.getConnection();
		try {
			//do something
			//System.out.println("Creating statement.");  
	        PreparedStatement stmt = con.prepareStatement("select * from sys_oper");  
	        //System.out.println("Executing statement.");  
	        ResultSet rset = stmt.executeQuery();  
	        System.out.println("Results:");  
	        while(rset.next()) { 
	        	//System.out.println(rset.getString("oper_id"));  
	            //System.out.println(""); 
	        }
			Thread.sleep(1000);
			//Thread.yield();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.freeConnection(con);
		}
	}

}
