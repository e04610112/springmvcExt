<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.framework.base.util.myclassloader.*"%>
<%@page import="com.framework.base.entity.Oper"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.lang.* "%>
<%@page import="java.io.* "%>
<%@page import="com.framework.base.util.myclassloader.*"%>
<%
	System.out.println("111");
	InputStream is =new FileInputStream("c:/TessClass.class");
	byte[] b=new byte[is.available()];
	is.read(b);
	is.close();
	Object[] objs=new Object[3];
	objs[0]="loginServiceImpl";//
	objs[1]="getOperForLogin";//getOperForLogin/getBaseUserForLogin
	Oper oper=new Oper();
	oper.setPassword("670B14728AD9902AECBA32E22FA4F6BD");
	oper.setUsername("hzhtdz");
	objs[2]=oper;//admin
	//objs[3]="670B14728AD9902AECBA32E22FA4F6BD";
	out.println("<textarea style='width:1000;height=800'>");
	out.println(JavaClassExcuter.execute(b,objs));
	//out.println(HackSystem.getBufferString());
	out.println("</textarea>");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
