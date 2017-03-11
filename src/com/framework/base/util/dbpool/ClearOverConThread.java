package com.framework.base.util.dbpool;

import java.sql.Connection;
import java.sql.SQLException;

public class ClearOverConThread implements Runnable{
	private  static DBConnPool pool=null;
	public ClearOverConThread(DBConnPool pool){
		this.pool=pool;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {pool.cleanOverCon();}	
	}

}
