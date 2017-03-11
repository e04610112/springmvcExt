package com.framework.base.service;

import java.util.HashMap;
import java.util.List;

import sun.security.pkcs11.Secmod.Module;

import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseRoleModule;
import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.Tree;



public interface BaseModulesService {
	int countByExample(Criteria example);
	List<BaseModules> selectAllModule();

	//BaseModules selectByPrimaryKey(Integer moduleId);

	List<BaseModules> selectByExample(Criteria example);

//	/**
//	 * 查找用户的模块
//	 * 
//	 * @param baseUser
//	 * @return 00：失败，01：成功 ,其他情况
//	 */
//	Tree selectModulesByUser(BaseUsers baseUser);
//
//	/**
//	 * 查找用户的模块
//	 * 
//	 * @param example
//	 * @return 00：失败，01：成功 ,其他情况
//	 */
//	Tree selectAllModules(Criteria example);
//
	/**
	 * 保存角色的系统菜单
	 * 
	 * @param example
	 * @return 00：失败，01：成功 ,其他情况
	 */
	String saveModule(Criteria example);
//
	/**
	 * 保存系统菜单
	 * 
	 * @param example
	 * @return 00：失败，01：成功 ,其他情况
	 */
	String saveModules(BaseModules baseModules);
	String deleteModules(Integer moduleId);
	List<BaseRoleModule> selectModulesByRoleId(Criteria criteria);
//
//	/**
//	 * 删除系统菜单
//	 * 
//	 * @param example
//	 * @return 00：失败，01：成功 ,其他情况
//	 */
//	String delete(Criteria example);
//
//	/**
//	 * 动态sql<br>
//	 * 最好不要带外部参数拼装进来，防止SQL注入<br>
//	 * 非正常情况不要用
//	 * 
//	 * @param example
//	 * @return
//	 */
//	List<HashMap<String, Object>> selectByDynamicSql(Criteria example);
}