package com.framework.base.util.apacheCommonsUtil.dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DbcpUtilTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 */
	public static void main(String[] args) {
		System.out.println("加载jdbc驱动");  
        try {  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        } catch (ClassNotFoundException e) {  
        e.printStackTrace();  
        }  
        System.out.println("Done.");  
        //  
        System.out.println("设置数据源");  
        DataSource dataSource = setupDataSource("jdbc:oracle:thin:@localhost:1521:orcl");  
        System.out.println("Done.");  
          
        //  
        Connection conn = null;  
        Statement stmt = null;  
        ResultSet rset = null;  
          
        try {  
	        System.out.println("Creating connection.");  
	        conn = dataSource.getConnection();  
	        System.out.println("Creating statement.");  
	        stmt = conn.createStatement();  
	        System.out.println("Executing statement.");  
	        rset = stmt.executeQuery("select * from sys_oper");  
	        System.out.println("Results:");  
	        while(rset.next()) { 
	        	System.out.println(rset.getString("oper_id"));  
	        System.out.println("");  
        }  
        } catch(SQLException e) {  
        	e.printStackTrace();  
        } finally {  
	        try { if (rset != null) rset.close(); } catch(Exception e) { }  
	        try { if (stmt != null) stmt.close(); } catch(Exception e) { }  
	        try { if (conn != null) conn.close(); } catch(Exception e) { }  
        }  // TODO Auto-generated method stub

	}
	public static DataSource setupDataSource(String connectURI) {  
		GenericObjectPool connectionPool = new GenericObjectPool(null);  
		//设置连接地址  
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(  
                connectURI, "ehangtian","1");  
  
        // 创建连接工厂  
        //PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory);  
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory,connectionPool,null,null,false,true);
        //获取GenericObjectPool 连接的实例  
//        ObjectPool connectionPool = new GenericObjectPool(  
//                poolableConnectionFactory);  
  
        // 创建 PoolingDriver  
        PoolingDataSource dataSource = new PoolingDataSource(poolableConnectionFactory.getPool());  
       
        return dataSource;  
    }  
}
