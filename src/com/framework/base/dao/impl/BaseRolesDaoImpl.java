package com.framework.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.framework.base.dao.BaseDao;
import com.framework.base.dao.BaseRolesDao;
import com.framework.base.entity.BaseRoles;
import com.framework.base.entity.Criteria;

@Repository
public class BaseRolesDaoImpl extends BaseDao  implements BaseRolesDao {

	

	
	

	public int countByExample(Criteria example) {
		// TODO Auto-generated method stub
		return (Integer) this.selectOne("roles.countByExample", example);
	}

	public List<BaseRoles> selectByExample(Criteria example) {
		// TODO Auto-generated method stub
		return this.selectList("roles.selectByExample",example);
	}
	public void deleteModuleByRoleId(String roleId){
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("roleId", roleId);
		this.delete("roles.deleteModuleByRoleId", parameterMap);
	}
	public void insertRoleModule(String roleId,Integer moduleId){
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("roleId", roleId);
		parameterMap.put("moduleId", moduleId.intValue());
		parameterMap.put("roleModuleId",  UUID.randomUUID().toString());
		this.insert("roles.insertRoleModule", parameterMap);
	}
}
