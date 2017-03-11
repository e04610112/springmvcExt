package com.framework.base.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.dao.BaseRolesDao;
import com.framework.base.entity.BaseRoles;
import com.framework.base.entity.Criteria;
import com.framework.base.service.BaseRolesService;

@Service
public class BaseRolesServiceImpl implements BaseRolesService {
	
	@Autowired
	private BaseRolesDao baseRolesDao;
	

	public int countByExample(Criteria example) {
		int count = this.baseRolesDao.countByExample(example);
		
		return count;
	}

//	public BaseRoles selectByPrimaryKey(String roleId) {
//		return this.baseRolesMapper.selectByPrimaryKey(roleId);
//	}

	public List<BaseRoles> selectByExample(Criteria example) {
		return this.baseRolesDao.selectByExample(example);
	}

//	@Override
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
//	public String saveRole(BaseRoles role) {
//		int result = 0;
//		if (StringUtils.isBlank(role.getRoleId())) {
//			result = this.baseRolesMapper.insertSelective(role);
//		} else {
//			result = this.baseRolesMapper.updateByPrimaryKeySelective(role);
//		}
//		return result > 0 ? "01" : "00";
//	}
//
//	@Override
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
//	public String deleteByPrimaryKey(Criteria criteria) {
//		String roleId = criteria.getAsString("roleId");
//		int result = 0;
//		// TODO 其他用户拥有该角色，还不能删除
//		int count = this.baseUserRoleMapper.countByExample(criteria);
//		if (count > 0) {
//			return "其他用户拥有该角色，还不能删除";
//		}
//		this.baseRoleModuleMapper.deleteByExample(criteria);
//		result = this.baseRolesMapper.deleteByPrimaryKey(roleId);
//		return result > 0 ? "01" : "00";
//	}
}