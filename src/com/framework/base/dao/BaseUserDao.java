package com.framework.base.dao;

import java.util.List;

import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;


public interface BaseUserDao {
	
	//public void Test();
	//public Oper getOperForLogin(Oper oper) ;
	//public void updateUser(Oper oper);
	//public BaseUsers getBaseUserForLogin(String account,String password);
	/**
	 * 根据条件查询记录集
	 */
	//List<BaseModules> selectMyModules(String userId);
	public int countByExample(Criteria example);
	public List<BaseUsers> selectByExample(Criteria example);
	//public List<BaseModules> selectAllModule();
	//public int insertBaseModules(BaseModules baseModules);
	//public int updateBaseModules(BaseModules baseModules);
	//public int deleteModules(Integer moduleId);
}
