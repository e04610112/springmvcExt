//package com.framework.base.service.impl;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.framework.base.entity.BaseRoleModule;
//import com.framework.base.entity.Criteria;
//import com.framework.base.service.BaseRoleModuleService;
//
//@Service
//public class BaseRoleModuleServiceImpl implements BaseRoleModuleService {
//	@Autowired
//	private BaseRoleModuleMapper baseRoleModuleMapper;
//
//	//private static final Logger logger = LoggerFactory.getLogger(BaseRoleModuleServiceImpl.class);
//
//	public int countByExample(Criteria example) {
//		int count = this.baseRoleModuleMapper.countByExample(example);
//		//logger.debug("count: {}", count);
//		return count;
//	}
//
//	public BaseRoleModule selectByPrimaryKey(String roleModuleId) {
//		return this.baseRoleModuleMapper.selectByPrimaryKey(roleModuleId);
//	}
//
//	public List<BaseRoleModule> selectByExample(Criteria example) {
//		return this.baseRoleModuleMapper.selectByExample(example);
//	}
//}