package com.framework.base.util.thread.callback;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class CallableDemo {
	class TaskWithResult implements Callable<String>{
		private int id;
		public TaskWithResult(int id){
			this.id=id;
		}
		@Override
		public String call() {
			// TODO Auto-generated method stub
			return "result of TaskWithResult "+id;
		}
		
	}
	/**
	 * @param args
	 *@author lyj [Apr 22, 2015]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService=Executors.newCachedThreadPool();
		ArrayList<Future<String>> results=new ArrayList<Future<String>>();
		for(int i=0;i<10;i++)
			results.add(executorService.submit(new CallableDemo().new TaskWithResult(i)));
		for (Future<String> future : results) {
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				System.out.println(e);
			}finally{
				executorService.shutdown();
			}
		}	
	}

}
