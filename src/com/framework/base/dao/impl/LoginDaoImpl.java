package com.framework.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.framework.base.dao.BaseDao;
import com.framework.base.dao.LoginDao;
import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.Oper;

@Repository
public class LoginDaoImpl extends BaseDao  implements LoginDao {

	public void test() {
		// TODO Auto-generated method stub
		
	}

	public Oper getOperForLogin(Oper oper) {
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("userName", oper.getUsername());
		parameterMap.put("password", oper.getPassword());//角色状态
		return (Oper)this.selectOne("login.getOperForLogin", oper);
	}
	
	public void updateUser(Oper oper){
		this.update("login.updateUser", oper);
	}
	public BaseUsers getBaseUserForLogin(String account,String password){
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("account", account);
		parameterMap.put("password", password);//角色状态
		return (BaseUsers)this.selectOne("login.getBaseUserForLogin", parameterMap);
	}
	/**
	 * 根据条件查询记录集
	 */
	public List<BaseModules> selectMyModules(String userId){
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("userId", userId);
		return this.selectList("login.selectMyModules",parameterMap);
	}
}
