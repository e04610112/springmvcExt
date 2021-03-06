package com.framework.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framework.base.entity.BaseRoles;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.ExtGridReturn;
import com.framework.base.entity.ExtPager;
import com.framework.base.entity.ExtReturn;
import com.framework.base.service.BaseRolesService;



/**
 * 角色
 * 
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController{

	
	@Autowired
	private BaseRolesService baseRolesService;

	/**
	 * index
	 */
	@RequestMapping(value = "admin")
	public String role() throws Exception{
		return "user/role";
	}

	/**
	 * 查找所有的角色
	 */
	@RequestMapping(value = "all", method = RequestMethod.POST)
	public ModelAndView all(ExtPager pager,  String roleName,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Criteria criteria = new Criteria();
		// 设置分页信息
		if (pager.getLimit() != null && pager.getStart() != null) {
			criteria.setOracleEnd(pager.getLimit() + pager.getStart());
			criteria.setOracleStart(pager.getStart());
		}
		// 排序信息
		if (StringUtils.isNotBlank(pager.getDir()) && StringUtils.isNotBlank(pager.getSort())) {
			criteria.setOrderByClause(pager.getSort() + " " + pager.getDir());
		}
		if (StringUtils.isNotBlank(roleName)) {
			criteria.put("roleNameLike", roleName);
		}
		List<BaseRoles> list = this.baseRolesService.selectByExample(criteria);
		int total = this.baseRolesService.countByExample(criteria);
		ExtReturn extReturn=new ExtGridReturn(total, list);
		extReturn.setSuccess(true);
		responseJson(extReturn,response);
		return null;
	}

//	/**
//	 * 保存角色信息
//	 */
//	@RequestMapping("/save")
//	@ResponseBody
//	public Object save(BaseRoles role) {
//		try {
//			if (role == null) {
//				return new ExtReturn(false, "角色不能为空!");
//			}
//			if (StringUtils.isBlank(role.getRoleName())) {
//				return new ExtReturn(false, "角色名称不能为空!");
//			}
//			//String result = this.baseRolesService.saveRole(role);
////			if ("01".equals(result)) {
////				return new ExtReturn(true, "保存成功！");
////			} else if ("00".equals(result)) {
////				return new ExtReturn(false, "保存失败！");
////			} else {
////				return new ExtReturn(false, result);
////			}
//			return null;
//		} catch (Exception e) {
//			return new ExceptionReturn(e);
//		}
//	}
//
//	/**
//	 * 删除该角色
//	 */
//	@RequestMapping("/del/{roleId}")
//	@ResponseBody
//	public Object delete(@PathVariable String roleId) {
//		try {
//			if (StringUtils.isBlank(roleId)) {
//				return new ExtReturn(false, "角色主键不能为空！");
//			}
//			Criteria criteria = new Criteria();
//			criteria.put("roleId", roleId);
//			String result =""; //this.baseRolesService.deleteByPrimaryKey(criteria);
//			if ("01".equals(result)) {
//				return new ExtReturn(true, "删除成功！");
//			} else if ("00".equals(result)) {
//				return new ExtReturn(false, "删除失败！");
//			} else {
//				return new ExtReturn(false, result);
//			}
//		} catch (Exception e) {
//			return new ExceptionReturn(e);
//		}
//	}
}
