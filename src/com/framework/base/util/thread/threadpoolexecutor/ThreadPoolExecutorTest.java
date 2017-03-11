package com.framework.base.util.thread.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	
	public static ExecutorService newFixedThreadPool(int nThreads) {  
	    return new ThreadPoolExecutor(nThreads, nThreads,  
	                                  0L, TimeUnit.MILLISECONDS,  
	                                  new LinkedBlockingQueue<Runnable>());  
	}

	public static ExecutorService newCachedThreadPool() {  
	    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,  
	                                  60L, TimeUnit.SECONDS,  
	                                  new SynchronousQueue<Runnable>());  
	}
	/*
	 * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                 long keepAliveTime, TimeUnit unit,
               BlockingQueue<Runnable> workQueue,
               RejectedExecutionHandler handler)
               
          corePoolSize： 线程池维护线程的最少数量
          maximumPoolSize：线程池维护线程的最大数量
          keepAliveTime： 线程池维护线程所允许的空闲时间
          unit： 线程池维护线程所允许的空闲时间的单位
          workQueue： 线程池所使用的缓冲队列
          handler： 线程池对拒绝任务的处理策略
            A.在默认的 ThreadPoolExecutor.AbortPolicy 中，
                处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
                任务放弃。
			B. 在 ThreadPoolExecutor.CallerRunsPolicy 中，
			   线程调用运行该任务的 execute 本身。
			   这个策略显然不想放弃执行任务。但是由于池中已经没有任何资源了，
			   那么就直接使用调用该execute的线程本身来执行。
			C. 在 ThreadPoolExecutor.DiscardPolicy 中，任务放弃。
			D. 在 ThreadPoolExecutor.DiscardOldestPolicy 中，
			   如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，
			    然后重试执行程序（如果再次失败，则重复此过程），很危险，建议不使用。


	 */
	private static int produceTaskSleepTime = 2;  
    
    private static int produceTaskMaxNumber = 10;  
	public static void main(String[] args) {
		  ThreadPoolExecutor threadPool =new ThreadPoolExecutor(2, 4, 3,  
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),  
                new ThreadPoolExecutor.CallerRunsPolicy());  
		  
		  for (int i = 1; i <= produceTaskMaxNumber; i++) {  
	             try {  
	                 String task = "task@ " + i;  
	                 System.out.println("创建任务并提交到线程池中：" + task);  
	                 threadPool.execute(new ThreadPoolTask(task));  
	   
	                 Thread.sleep(produceTaskSleepTime);  
	             } catch (Exception e) {  
	                 e.printStackTrace();  
	             }  
	 
		
	}
	}
}
