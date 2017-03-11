package com.framework.base.dao;

import java.util.List;

import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;


public interface BaseFieldsDao {
	
//	public void Test();
//	public Oper getOperForLogin(Oper oper) ;
//	public void updateUser(Oper oper);
//	public BaseUsers getBaseUserForLogin(String account,String password);
//	/**
//	 * 根据条件查询记录集
//	 */
//	List<BaseModules> selectMyModules(String userId);
	public int countByExample(Criteria example);
	public List<BaseFields> selectByExample(Criteria example);
	public List<BaseFields> selectAllByExample(Criteria example);
	public int insertBaseFields(BaseFields baseFields);
	public int updateBaseFields(BaseFields baseFields);
	public int deleteBaseFieldsById(String fieldId);
//	public List<BaseModules> selectAllModule();
}
