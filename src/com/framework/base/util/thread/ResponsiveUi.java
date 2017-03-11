package com.framework.base.util.thread;

import java.io.IOException;

public class ResponsiveUi extends Thread{
	private static volatile double d=1;
	public ResponsiveUi(){
		setDaemon(true);
		start();
	}
	public void run(){
		while(true){
			d=d+(Math.PI+Math.E)/d;
		}
	}
	/**
	 * @param args
	 *@author lyj [Apr 23, 2015]
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new ResponsiveUi();
		System.in.read();
		System.out.println(d);
	}

}
