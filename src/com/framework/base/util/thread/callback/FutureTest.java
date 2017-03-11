package com.framework.base.util.thread.callback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

	/**
	 * @param args
	 *@author lyj [May 28, 2015]
	 */
	public static void main(String[] args) {
		Callable<Integer> func = new Callable<Integer>(){  
		    public Integer call() throws Exception {  
		        System.out.println("inside callable");  
		        Thread.sleep(1000);  
		        return new Integer(8);  
		    }         
		}; 
		FutureTask futureTask  = new FutureTask(func);  
		Thread newThread = new Thread(futureTask);  
		newThread.start();  
		
		try {  
		    System.out.println("blocking here");  
		    Integer result = (Integer)futureTask.get();  
		    System.out.println(result);  
		} catch (InterruptedException ignored) {  
		} catch (ExecutionException ignored) {  
		} 


	}

}
