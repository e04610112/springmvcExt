package com.framework.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.framework.base.dao.BaseDao;
import com.framework.base.dao.BaseUserDao;
import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;

@Repository
public class BaseUserDaoImpl extends BaseDao  implements BaseUserDao {

	

	
	

	public int countByExample(Criteria example) {
		// TODO Auto-generated method stub
		return (Integer) this.selectOne("user.countByExample", example);
	}

	public List<BaseUsers> selectByExample(Criteria example) {
		// TODO Auto-generated method stub
		return this.selectList("user.selectByExample",example);
	}
	
}
