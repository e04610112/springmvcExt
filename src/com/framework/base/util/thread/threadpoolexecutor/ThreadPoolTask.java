package com.framework.base.util.thread.threadpoolexecutor;

public class ThreadPoolTask implements Runnable{
	private Object attachData;  
	   
    ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
  
    public void run() {  
          
        System.out.println("开始执行任务：" + attachData);  
          
        attachData = null;  
    }  
  
    public Object getTask() {  
        return this.attachData;  
    }  

}
