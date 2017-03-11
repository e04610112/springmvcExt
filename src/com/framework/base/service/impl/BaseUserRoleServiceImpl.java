//package com.framework.base.service.impl;
//
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.framework.base.entity.BaseUserRole;
//import com.framework.base.entity.Criteria;
//import com.framework.base.service.BaseUserRoleService;
//
//@Service
//public class BaseUserRoleServiceImpl implements BaseUserRoleService {
//	@Autowired
//	private BaseUserRoleMapper baseUserRoleMapper;
//
//	//private static final Logger logger = LoggerFactory.getLogger(BaseUserRoleServiceImpl.class);
//
//	public int countByExample(Criteria example) {
//		int count = this.baseUserRoleMapper.countByExample(example);
//		//logger.debug("count: {}", count);
//		return count;
//	}
//
//	public BaseUserRole selectByPrimaryKey(String userRoleId) {
//		return this.baseUserRoleMapper.selectByPrimaryKey(userRoleId);
//	}
//
//	public List<BaseUserRole> selectByExample(Criteria example) {
//		return this.baseUserRoleMapper.selectByExample(example);
//	}
//
//}