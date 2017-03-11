package com.framework.base.dao;

import java.util.List;

import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;


public interface ScheduleDao {
	
	public List<BaseFields> selectAllFiled(Criteria example);
	
}
