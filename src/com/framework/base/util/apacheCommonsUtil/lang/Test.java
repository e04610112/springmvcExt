package com.framework.base.util.apacheCommonsUtil.lang;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class Test {
	private String userName;
	public String userNamepublic;
	public static String STATIC_FIELD="staticfieldvalue";
	public Test(){}
	public Test(String userName,String userNamepublic){
		this.userName=userName;
		this.userNamepublic=userNamepublic;
	}
	public void publicHello(){
		System.out.println("publicHello");
	}
	public void publicHello(String ss){
		System.out.println("publicHello:"+ss);
	}
	public void publicHello(String ss,int s){
		System.out.println("publicHello:"+ss+":"+s);
	}
	public static void staticHello(){
		System.out.println("staticHello");
	}
}
