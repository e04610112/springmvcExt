package com.framework.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.framework.base.dao.BaseDao;
import com.framework.base.dao.ScheduleDao;
import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;

@Repository
public class ScheduleDaoImpl extends BaseDao implements ScheduleDao {

public List<BaseFields> selectAllFiled(Criteria example){
		
		return  this.selectList("fields.selectAllByExample",example);
	}
}
