package com.framework.base.service;

import java.util.List;

import com.framework.base.entity.BaseUserRole;
import com.framework.base.entity.Criteria;



public interface BaseUserRoleService {
	int countByExample(Criteria example);

	BaseUserRole selectByPrimaryKey(String userRoleId);

	List<BaseUserRole> selectByExample(Criteria example);

}