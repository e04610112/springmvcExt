package com.framework.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.framework.base.dao.BaseDao;
import com.framework.base.dao.ModuleDao;
import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseRoleModule;
import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.Oper;

@Repository
public class ModuleDaoImpl extends BaseDao  implements ModuleDao {

	

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

	public void test() {
		// TODO Auto-generated method stub
		
	}

	public int countByExample(Criteria example) {
		// TODO Auto-generated method stub
		return (Integer) this.selectOne("module.countByExample", example);
	}

	public List<BaseModules> selectByExample(Criteria example) {
		// TODO Auto-generated method stub
		return this.selectList("module.selectByExample",example);
	}
	public List<BaseModules> selectAllModule(){
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		return this.selectList("module.selectAllModule",parameterMap);
	}
	public int insertBaseModules(BaseModules baseModules){
		return this.insert("module.insertBaseModules", baseModules);
	}
	public int updateBaseModules(BaseModules baseModules){
		return this.update("module.updateBaseModules", baseModules);
	}
	public int deleteModules(Integer moduleId){
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("moduleId", moduleId);
		return this.delete("module.deleteModules", parameterMap);
	}
	public List<BaseRoleModule> selectModulesByRoleId(Criteria criteria){
		return this.selectList("module.selectModulesByRoleId",criteria);
	}
}
