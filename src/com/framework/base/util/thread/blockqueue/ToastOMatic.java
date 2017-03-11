package com.framework.base.util.thread.blockqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
	
	/**
	 * @param args
	 *@author lyj [Apr 27, 2015]
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ToastQueue dryQueue=new ToastQueue();
		ToastQueue buffQueue=new ToastQueue();
		ToastQueue finishQueue=new ToastQueue();
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(new Toaster(dryQueue));
		executorService.execute(new Butter(dryQueue,buffQueue));
		executorService.execute(new Jammer(buffQueue,finishQueue));
		executorService.execute(new Eater(finishQueue));
		TimeUnit.SECONDS.sleep(1);
		executorService.shutdownNow();
	}

}
