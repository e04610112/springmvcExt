package com.framework.base.dao;

import java.util.List;

import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.Oper;


public interface LoginDao {
	
	public void test();
	public Oper getOperForLogin(Oper oper) ;
	public void updateUser(Oper oper);
	public BaseUsers getBaseUserForLogin(String account,String password);
	/**
	 * 根据条件查询记录集
	 */
	List<BaseModules> selectMyModules(String userId);
}
