package com.framework.base.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.dao.BaseRolesDao;
import com.framework.base.dao.ModuleDao;
import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseRoleModule;
import com.framework.base.entity.Criteria;
import com.framework.base.service.BaseModulesService;

@Service
public class BaseModulesServiceImpl implements BaseModulesService {
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private BaseRolesDao baseRolesDao;


	//private static final Logger logger = LoggerFactory.getLogger(BaseModulesServiceImpl.class);

//	@Override
//	public Tree selectAllModules(Criteria example) {
//		example.setDistinct(true);
//		example.setOrderByClause(" DISPLAY_INDEX ASC");
//		if (!isDisplay) {
//			// 是否显示 0:否 1:是
//			// 这个条件表示只显示允许显示的模块，否则没有这个条件会显示所有的模块
//			example.put("isDisplay", 1);
//		}
//		List<BaseModules> list = this.baseModulesMapper.selectByExample(example);
//		TreeMenu menu = new TreeMenu(list);
//		return menu.getTreeJson();
//	}
//
//	@Override
//	public Tree selectModulesByUser(BaseUsers baseUser) {
//		Criteria example = new Criteria();
//		example.setDistinct(true);
//		if (!isDisplay) {
//			// 是否显示 0:否 1:是
//			// 这个条件表示只显示允许显示的模块，否则没有这个条件会显示所有的模块
//			example.put("isDisplay", 1);
//		}
//		List<BaseModules> list = null;
//		// 显示所有模块
//		if (resoved) {
//			example.setOrderByClause(" DISPLAY_INDEX ASC");
//			list = this.baseModulesMapper.selectByExample(example);
//		} else {
//			// 显示当前用户权限模块，从配置表中获取
//			example.setOrderByClause(" a.display_index ASC");
//			example.put("userId", baseUser.getUserId());
//			list = this.baseModulesMapper.selectMyModules(example);
//		}
//		TreeMenu menu = new TreeMenu(list);
//		return menu.getTreeJson();
//	}
//
	
	@Override
	
	public String saveModule(Criteria criteria) {
		
		
			String roleId = criteria.getAsString("roleId");
			ArrayList<Integer> modulesIds = (ArrayList<Integer>) criteria.get("modulesIdList");
			// 删除以前的资源
			this.baseRolesDao.deleteModuleByRoleId(roleId);
			for (Integer moduleId : modulesIds) {
				if (moduleId != null) {
					
					this.baseRolesDao.insertRoleModule(roleId,moduleId);
				}
			}
		
		return "01";
	}


	public String saveModules(BaseModules baseModules) {
		
		int result = 0;
		if (baseModules.getModuleId() == null) {
			result = moduleDao.insertBaseModules(baseModules);
		} else {
			result = moduleDao.updateBaseModules(baseModules);
		}
		return result > 0 ? "01" : "00";
	}

	public String deleteModules(Integer moduleId) {
		
		int result = 0;
		result = this.moduleDao.deleteModules(moduleId);
		return result > 0 ? "01" : "00";
	}

	public int countByExample(Criteria example) {
		int count = moduleDao.countByExample(example);
		
		return count;
	}
	
	public List<BaseModules> selectByExample(Criteria example) {
		return moduleDao.selectByExample(example);
	}
	public List<BaseModules> selectAllModule(){
		return moduleDao.selectAllModule();
	}
	public List<BaseRoleModule> selectModulesByRoleId(Criteria criteria){
		return moduleDao.selectModulesByRoleId(criteria);
	}
//	public BaseModules selectByPrimaryKey(Integer moduleId) {
//		return this.baseModulesMapper.selectByPrimaryKey(moduleId);
//	}
//
//
//
//	@Override
//	public List<HashMap<String, Object>> selectByDynamicSql(Criteria example) {
//		return this.baseModulesMapper.selectByDynamicSql(example);
//	}

}