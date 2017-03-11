package com.framework.base.util.thread.callback;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureTask extends FutureTask {

	public MyFutureTask(Callable callable) {
		super(callable);
		// TODO Auto-generated constructor stub
	}

}
