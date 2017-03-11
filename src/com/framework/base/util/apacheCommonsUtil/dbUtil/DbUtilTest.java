package com.framework.base.util.apacheCommonsUtil.dbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.framework.base.util.apacheCommonsUtil.beanUtil.Person;
import com.framework.base.util.apacheCommonsUtil.dbcp.DbcpConnect;

public class DbUtilTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 */
	public static void main(String[] args) {
		Connection    conn=null;
	     
		  
	    try {   
	    	conn= DbcpConnect.getConnection();
	        QueryRunner qr = new QueryRunner();  
	        //直接转换成object
	        List results = (List) qr.query(conn, "select 'tom' name,'email' email,1 age from sys_oper", new BeanListHandler(Person.class));  
	        for (int i = 0; i < results.size(); i++) {  
	            Person p = (Person) results.get(i);  
	            System.out.println("id:" + p.getEmail() + ",name:" + p.getName());  
	        }  
	        //Map形式
	        List results1 = (List) qr.query(conn, "select 'tom' name,'email' email,1 age from sys_oper", new MapListHandler());  
            for (int i = 0; i < results1.size(); i++) {  
                Map map = (Map) results1.get(i);  
                System.out.println("name:" + map.get("name") + ",email:" + map.get("email"));  
            }  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } finally {  
	        DbUtils.closeQuietly(conn);  
	    }  
		}  // TODO Auto-generated method stub

	

}
