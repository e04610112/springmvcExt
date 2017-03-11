package com.framework.base.service;


import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Oper;
import com.framework.base.entity.Tree;


public interface LoginService {
	
	public void test();
	public Oper getOperForLogin(Oper oper);
	public void updateUser(Oper oper);
	public BaseUsers getBaseUserForLogin(String account,String password);
	/**
	 * 查找用户的模块
	 * 
	 * @param baseUser
	 * @return 00：失败，01：成功 ,其他情况
	 */
	Tree selectModulesByUser(BaseUsers baseUser);
	
}
