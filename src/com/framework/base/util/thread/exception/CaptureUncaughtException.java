package com.framework.base.util.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.aspectj.runtime.internal.cflowstack.ThreadCounter;

public class CaptureUncaughtException {
	class ExceptionThread2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Thread thread=Thread.currentThread();
			System.out.println("run() by"+thread);
			System.out.println("eh="+thread.getUncaughtExceptionHandler());
			throw new RuntimeException();
		}
	}
	class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("catch:"+e);
		}
	}
	class HandlerThreadFactory implements ThreadFactory{

		@Override
		public Thread newThread(Runnable r) {
			Thread t=new Thread(r);
			System.out.println("creat:"+t);
			t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
			System.out.println("eh="+t.getUncaughtExceptionHandler());
			return t;
		}
	}
	public static void main(String[] args){
		ExecutorService executorService=Executors.newCachedThreadPool(new CaptureUncaughtException().new HandlerThreadFactory());
		executorService.execute(new CaptureUncaughtException().new ExceptionThread2());
	}
}
