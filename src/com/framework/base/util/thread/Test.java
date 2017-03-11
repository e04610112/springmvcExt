package com.framework.base.util.thread;

import java.util.ArrayList;
import java.util.Vector;

public class Test {
	private static Vector<Integer> vector=new Vector<Integer>();
	private static ArrayList<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args) {
		while (true) {
			for(int i=0;i<10;i++){
				//vector.add(i);
				list.add(i);
			}
			Thread removeThread=new Thread(new Runnable(){
				
				public void run() {
					synchronized (list) {
						for(int i=0;i<list.size();i++){
							list.remove(i);
						}
					}
				}
			});
			Thread printThread=new Thread(new Runnable(){
				public void run() {
					synchronized (list){
						for(int i=0;i<list.size();i++){
							System.out.println(list.get(i));
						}
					}
				}
			});
			removeThread.start();
			printThread.start();
			while (Thread.activeCount()>20);
		}
		
	}
}
