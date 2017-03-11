package com.framework.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(String statement){
		return this.sqlSessionTemplate.insert(statement);
	}
	
	public int insert(String statement,Object parameter){
		return this.sqlSessionTemplate.insert(statement, parameter);
	}
	
	public int delete(String statement){
		return this.sqlSessionTemplate.delete(statement);
	}
	
	public int delete(String statement,Object parameter){
		return this.sqlSessionTemplate.delete(statement, parameter);
	}
	
	public Object selectOne(String statement){
		return this.sqlSessionTemplate.selectOne(statement);
	}
	
	public Object selectOne(String statement,Object parameter){
		return this.sqlSessionTemplate.selectOne(statement, parameter);
	}
	
	public List selectList(String statement){
		return this.sqlSessionTemplate.selectList(statement);
	}
	
	public List selectList(String statement,Object parameter){
		return this.sqlSessionTemplate.selectList(statement, parameter);
	}
	
	public List selectList(String statement,Object parameter,RowBounds rowBounds){
		return this.sqlSessionTemplate.selectList(statement, parameter, rowBounds);
	}
	
	public Map<Object,Object> selectMap(String statement,String mapKey){
		return this.sqlSessionTemplate.selectMap(statement, mapKey);
	}
	
	public Map<Object,Object> selectMap(String statement,Object parameter,String mapKey){
		return this.sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}
	
	public Map<Object,Object> selectMap(String statement,Object parameter,String mapKey,RowBounds rowBounds){
		return this.sqlSessionTemplate.selectMap(statement, parameter, mapKey, rowBounds);
	}
	
	public void select(String statement,ResultHandler handler){
		this.sqlSessionTemplate.select(statement, handler);
	}
	
	public void select(String statement,Object parameter,ResultHandler handler){
		this.sqlSessionTemplate.select(statement, parameter, handler);
	}
	
	public void select(String statement,Object parameter,RowBounds rowBounds,ResultHandler handler){
		this.sqlSessionTemplate.select(statement, parameter, rowBounds, handler);
	}
	
	public int update(String statement){
		return this.sqlSessionTemplate.update(statement);
	}
	
	public int update(String statement,Object parameter){
		return this.sqlSessionTemplate.update(statement, parameter);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

}
