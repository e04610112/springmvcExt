package com.framework.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.dao.LoginDao;
import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.Oper;
import com.framework.base.entity.Tree;
import com.framework.base.entity.TreeMenu;
import com.framework.base.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	public void test() {
		
		loginDao.test();
	}

	public Oper getOperForLogin(Oper oper) {
		
		return loginDao.getOperForLogin(oper);
	}
	public void updateUser(Oper oper){
		loginDao.updateUser(oper);
//		if(true){
//			throw new RuntimeException();
//		}
		
	}
	public BaseUsers getBaseUserForLogin(String account,String password){
		return loginDao.getBaseUserForLogin(account,password);
	}
	public Tree selectModulesByUser(BaseUsers baseUser) {
		Criteria example = new Criteria();
		example.setDistinct(true);
	
		// 是否显示 0:否 1:是
		// 这个条件表示只显示允许显示的模块，否则没有这个条件会显示所有的模块
		
		
		List<BaseModules> list = null;
		// 显示所有模块
//		if (resoved) {
//			example.setOrderByClause(" DISPLAY_INDEX ASC");
//			list = this.baseModulesMapper.selectByExample(example);
//		} else {
			// 显示当前用户权限模块，从配置表中获取
			
		
			list = loginDao.selectMyModules(baseUser.getUserId());
//		}
		TreeMenu menu = new TreeMenu(list);
		return menu.getTreeJson();
	}

	
}
