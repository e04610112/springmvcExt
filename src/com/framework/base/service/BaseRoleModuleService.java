package com.framework.base.service;

import java.util.List;

import com.framework.base.entity.BaseRoleModule;
import com.framework.base.entity.Criteria;



public interface BaseRoleModuleService {
	int countByExample(Criteria example);

	BaseRoleModule selectByPrimaryKey(String roleModuleId);

	List<BaseRoleModule> selectByExample(Criteria example);
}