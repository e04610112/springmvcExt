package com.framework.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.framework.base.dao.BaseDao;
import com.framework.base.dao.BaseFieldsDao;
import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.Oper;

@Repository
public class BaseFiledsDaoImpl extends BaseDao  implements BaseFieldsDao {

	

	public Oper getOperForLogin(Oper oper) {
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("userName", oper.getUsername());
		parameterMap.put("password", oper.getPassword());//角色状态
		return (Oper)this.selectOne("login.getOperForLogin", oper);
	}
	
	public List<BaseFields> selectByExample(Criteria example){
		
		return  this.selectList("fields.selectByExample",example);
	}
	public int countByExample(Criteria example){
		
		return (Integer) this.selectOne("fields.countByExample", example);
	}
	public List<BaseFields> selectAllByExample(Criteria example){
			
			return  this.selectList("fields.selectAllByExample",example);
		}
	
	@Override
	public int insertBaseFields(BaseFields baseFields) {
		return this.insert("fields.insertBaseFields", baseFields);
	}
	
	@Override
	public int updateBaseFields(BaseFields baseFields) {
		return this.update("fields.updateBaseFields", baseFields);
	}

	@Override
	public int deleteBaseFieldsById(String fieldId) {
		// TODO Auto-generated method stub
		Map<Object,Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("fieldId", fieldId);
		return this.delete("fields.deleteBaseFieldsById",parameterMap);
	}


}
