package com.framework.base.util.apacheCommonsUtil.httpClien;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
/**
 * HttpClien 基于HttpCore实 现的一个HTTP/1.1兼容的HTTP客户端，
 * 它提供了一系列可重用的客户端身份验证、HTTP状态保持、HTTP连接管理module。
 * @author Administrator
 *
 */
public class HttpClineTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static void main(String[] args) throws HttpException, IOException {
		testPost();
	}
	public static void testGet(){
		 // 构造HttpClient的实例  
        HttpClient httpClient = new HttpClient();  
        // 创建GET方法的实例  
        GetMethod getMethod = new GetMethod("http://www.baidu.com");  
        // 使用系统提供的默认的恢复策略  
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler());  
        try {  
            // 执行getMethod  
            int statusCode = httpClient.executeMethod(getMethod);  
            if (statusCode != HttpStatus.SC_OK) {  
                System.err.println("Method failed: "  
                        + getMethod.getStatusLine());  
            }  
            // 读取内容  
            byte[] responseBody = getMethod.getResponseBody();  
            // 处理内容  
            System.out.println(new String(responseBody));  
        } catch (HttpException e) {  
            // 发生致命的异常，可能是协议不对或者返回的内容有问题  
            System.out.println("Please check your provided http address!");  
            e.printStackTrace();  
        } catch (IOException e) {  
            // 发生网络异常  
            e.printStackTrace();  
        } finally {  
            // 释放连接  
            getMethod.releaseConnection();  
        }  // TODO Auto-generated method stub

	}
	public static void testPost() throws HttpException, IOException{
		 // 构造HttpClient的实例  
        HttpClient httpClient = new HttpClient();  
        // 创建POST方法的实例  
        String url = "http://www.oracle.com/";  
        PostMethod postMethod = new PostMethod(url);  
        // 填入各个表单域的值  
        NameValuePair[] data = { new NameValuePair("id", "youUserName"),  
        new NameValuePair("passwd", "yourPwd") };  
        // 将表单的值放入postMethod中  
        postMethod.setRequestBody(data);  
        // 执行postMethod  
        int statusCode = httpClient.executeMethod(postMethod);  
        // HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发  
        // 301或者302  
        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY ||   
        statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {  
            // 从头中取出转向的地址  
            Header locationHeader = postMethod.getResponseHeader("location");  
            String location = null;  
            if (locationHeader != null) {  
             location = locationHeader.getValue();  
             System.out.println("The page was redirected to:" + location);  
            } else {  
             System.err.println("Location field value is null.");  
            }  
            return;  
        }  
	}

}
