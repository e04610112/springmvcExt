package com.framework.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framework.base.entity.BaseModules;
import com.framework.base.entity.BaseRoleModule;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.ExtGridReturn;
import com.framework.base.entity.ExtPager;
import com.framework.base.entity.ExtReturn;
import com.framework.base.entity.TreeMenu;
import com.framework.base.service.BaseModulesService;
import com.framework.base.util.Parameters;
import com.google.gson.Gson;



/**
 * 后台资源、系统菜单相关
 * 
 */
@Controller
public class ModuleController extends BaseController{

	
	@Autowired
	private BaseModulesService baseModulesService;
//	@Autowired
//	private BaseRoleModuleService baseRoleModuleService;

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Date.class, new DateConvertEditor());
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	}

	/**
	 * index
	 */
	@RequestMapping(value = "module/module", method = RequestMethod.GET)
	public String module(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 先查出所有的父节点
		Criteria criteria = new Criteria();
		StringBuilder sb = new StringBuilder();
		sb.append("select a.module_id   , ").append(" a.module_name ").append("from   base_modules a ")
				.append("where  a.leaf = 0 ").append("order by a.module_id asc ");
		criteria.put("dynamicSql", sb.toString());
		List<HashMap<String, Object>> list ;
		List<BaseModules> listBaseModules= this.baseModulesService.selectAllModule();
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		
		for (BaseModules baseModules : listBaseModules) {
			map.put(baseModules.getModuleId(), baseModules.getModuleName());
		}
		map.put("0", "主菜单");
		Gson gson = new Gson();
		request.setAttribute("moduleMap", gson.toJson(map));
		//System.out.println("_______________"+gson.toJson(map));
		//System.out.println("_______________"+gson.toJson(Parameters.fieldsMaps).replaceAll("\\'", "\\\\'"));
		//request.setAttribute("fieldsMaps", gson.toJson(Parameters.fieldsMaps));
		return "user/module";
	}

//	/**
//	 * 查找系统的所有菜单
//	 * 
//	 * @throws IOException
//	 */
//	@RequestMapping(value = "/all")
//	public void all(PrintWriter writer) throws IOException {
//		Criteria criteria = new Criteria();
//		Tree tree = this.baseModulesService.selectAllModules(criteria);
//		String json = JackJson.fromObjectToJson(tree.getChildren());
//		// 加入check
//		writer.write(json.replaceAll("\"leaf", "\"checked\":false,\"leaf"));
//		writer.flush();
//		writer.close();
//	}

	/**
	 * 所有菜单信息
	 */
	@RequestMapping(value="module/all")
	public ModelAndView all(ExtPager pager,  String moduleName,HttpSession session, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ExtGridReturn extReturn=null;
		Criteria criteria = new Criteria();
		// 设置分页信息
		if (pager.getLimit() != null && pager.getStart() != null) {
			criteria.setOracleEnd(pager.getLimit() + pager.getStart());
			criteria.setOracleStart(pager.getStart());
		}
		if (StringUtils.isNotBlank(moduleName)) {
			criteria.put("moduleNameLike", moduleName);
		}
		List<BaseModules> list = this.baseModulesService.selectByExample(criteria);
		int total = this.baseModulesService.countByExample(criteria);
		
		extReturn= new ExtGridReturn(total, list);
		extReturn.setSuccess(true);
		Gson gson = new Gson();
		System.out.println(gson.toJson(extReturn));
		responseJson(extReturn,response);
		return null;
	}
	/**
	 * 所有菜单信息
	 */
	@RequestMapping(value="module/allForTree")
	public ModelAndView allForTree(HttpSession session, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ExtGridReturn extReturn=null;
		Criteria criteria = new Criteria();
		List<BaseModules> list = this.baseModulesService.selectByExample(criteria);
		TreeMenu menu = new TreeMenu(list);
		Gson gson = new Gson();
		System.out.println(gson.toJson( menu.getTreeJson().getChildren()));
		//设置多选框
		responseJson(gson.toJson(menu.getTreeJson().getChildren()).replaceAll("\"leaf", "\"checked\":false,\"leaf"),response);
		return null;
	}

	/**
	 * 加载此角色的所有资源
	 */
	@RequestMapping(value="module/selectModulesByRoleId")
	
	public ModelAndView selectModulesByRoleId( String roleId,HttpServletResponse response)throws Exception {
		ExtReturn extReturn=null;
		if (StringUtils.isBlank(roleId)) {
			extReturn= new ExtReturn(false, "角色ID不能为空！");
		}
		Criteria criteria = new Criteria();
		criteria.put("roleId", roleId);
		List<BaseRoleModule> list = this.baseModulesService.selectModulesByRoleId(criteria);
		responseJson(list,response);
		return null;
	}

	/**
	 * 保存角色的系统菜单信息
	 * @throws Exception 
	 */
	@RequestMapping(value="module/saverole")
	public ModelAndView saverole(String roleId, String moduleIds,HttpServletResponse response) throws Exception {
		ExtReturn extReturn=null;
		List<Integer> modulesIdList = new ArrayList<Integer>();
		if (StringUtils.isBlank(roleId)) {
			extReturn=new ExtReturn(false, "角色不能为空！");
		}
		if (StringUtils.isBlank(moduleIds)) {
			extReturn=new ExtReturn(false, "选择的资源不能为空！");
		} else {
			String[] modules = StringUtils.split(moduleIds, ",");
			if (null == modules || modules.length == 0) {
				extReturn=new ExtReturn(false, "选择的资源不能为空！");
			}
			for (int i = 0; i < modules.length; i++) {
				modulesIdList.add(new Integer(modules[i]));
			}
		}
		//logger.debug("save() - String roleId={}", roleId);
		//logger.debug("save() - String moduleIds={}", moduleIds);
		Criteria criteria = new Criteria();
		criteria.put("modulesIdList", modulesIdList);
		criteria.put("roleId", roleId);
		String result = this.baseModulesService.saveModule(criteria);
		if ("01".equals(result)) {
			extReturn= new ExtReturn(true, "保存成功！");
		} else if ("00".equals(result)) {
			extReturn=new ExtReturn(false, "保存失败！");
		} else {
			extReturn=new ExtReturn(false, result);
		}
		//int i=1/0;
		return null;
	}

	/**
	 * 保存系统菜单信息
	 */
	@RequestMapping(value="module/save")
	public ModelAndView save(BaseModules baseModules,HttpSession session, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ExtReturn extReturn=null;
		
		if (baseModules == null) {
			extReturn=new ExtReturn(false, "模块不能为空！");
		}
		if (StringUtils.isBlank(baseModules.getModuleName())) {
			extReturn=new ExtReturn(false, "模块名称不能为空！");
		}
		
		String result = this.baseModulesService.saveModules(baseModules);
		if ("01".equals(result)) {
			extReturn=new ExtReturn(true, "保存成功！");
		} else if ("00".equals(result)) {
			extReturn=new ExtReturn(false, "保存失败！");
		} else {
			extReturn=new ExtReturn(false, result);
		}
		responseJson(extReturn,response);
		return null;
	}
//
//	/**
//	 * 删除该模块
//	 */
	@RequestMapping(value="module/del")
	public ModelAndView deleteModules(Integer moduleId,HttpSession session, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ExtReturn extReturn=null;
		
		if (StringUtils.isBlank(moduleId+"")) {
			extReturn=new ExtReturn(false, "模块主键不能为空！");
		}
		String result = this.baseModulesService.deleteModules(moduleId);
		if ("01".equals(result)) {
			extReturn=new ExtReturn(true, "删除成功！");
		} else if ("00".equals(result)) {
			extReturn=new ExtReturn(false, "删除失败！");
		} else {
			extReturn=new ExtReturn(false, result);
		}
		responseJson(extReturn,response);
		return null;
	}
}
