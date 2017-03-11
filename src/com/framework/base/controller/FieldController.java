package com.framework.base.controller;



import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;
import com.framework.base.entity.ExtGridReturn;
import com.framework.base.entity.ExtPager;
import com.framework.base.entity.ExtReturn;
import com.framework.base.exception.ExceptionReturn;
import com.framework.base.service.BaseFieldsService;

/**
 * 系统字段设置
 * 
 */
@Controller
@RequestMapping("field")
public class FieldController extends BaseController{
	

	@Autowired
	private BaseFieldsService baseFieldsService;

	/**
	 * index
	 */
	@RequestMapping(value = "admin")
	public String admin() throws Exception{
		return "user/field";
	}

	/**
	 * 所有系统字段
	 */
	@RequestMapping(value = "all")
	
	public ModelAndView all(ExtPager pager,String fieldName,HttpServletResponse response) throws Exception{
		
		Criteria criteria = new Criteria();
		// 设置分页信息
		if (pager.getLimit() != null && pager.getStart() != null) {
			criteria.setOracleEnd(pager.getLimit() + pager.getStart());
			criteria.setOracleStart(pager.getStart());
		}
		// 排序信息
		if (StringUtils.isNotBlank(pager.getDir()) && StringUtils.isNotBlank(pager.getSort())) {
			criteria.setOrderByClause(pager.getSort() + " " + pager.getDir());
		} else {
			criteria.setOrderByClause(" field desc ,sort asc ");
		}
		if (StringUtils.isNotBlank(fieldName)) {
			criteria.put("fieldNameLike", fieldName);
		}
		List<BaseFields> list = this.baseFieldsService.selectByExample(criteria);
		int total = this.baseFieldsService.countByExample(criteria);
		ExtReturn extReturn=new ExtGridReturn(total, list);
		extReturn.setSuccess(true);
		responseJson(extReturn,response);
		return null;
		
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="save")
	public ModelAndView save(BaseFields fields,HttpServletResponse response) throws Exception{
		ExtReturn extReturn;
		if (fields == null) {
			extReturn= new ExtReturn(false, "系统字段不能为空！");
		}
		if (StringUtils.isBlank(fields.getField())) {
			extReturn= new ExtReturn(false, "字段不能为空！");
		}
		if (StringUtils.isBlank(fields.getFieldName())) {
			extReturn= new ExtReturn(false, "字段名称不能为空！");
		}
		if (StringUtils.isBlank(fields.getValueField())) {
			extReturn= new ExtReturn(false, "字段值不能为空！");
		}
		if (StringUtils.isBlank(fields.getDisplayField())) {
			extReturn= new ExtReturn(false, "字段显示值不能为空！");
		}
		Criteria criteria = new Criteria();
		criteria.put("fields", fields);
		String result = this.baseFieldsService.saveFields(criteria);
		if ("01".equals(result)) {
			extReturn= new ExtReturn(true, "保存成功！");
		} else if ("00".equals(result)) {
			extReturn= new ExtReturn(false, "保存失败！");
		} else {
			extReturn= new ExtReturn(false, result);
		}
		responseJson(extReturn,response);
		return null;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="del")
	public ModelAndView deleteFields(String fieldId,HttpServletResponse response) throws Exception{
		ExtReturn extReturn;
		if (StringUtils.isBlank(fieldId)) {
			extReturn= new ExtReturn(false, "主键不能为空！");
		}
		Criteria criteria = new Criteria();
		criteria.put("fieldId", fieldId);
		String result = this.baseFieldsService.deleteFields(criteria);
		if ("01".equals(result)) {
			extReturn= new ExtReturn(true, "删除成功！");
		} else if ("00".equals(result)) {
			extReturn= new ExtReturn(false, "删除失败！");
		} else {
			extReturn= new ExtReturn(false, result);
		}
		responseJson(extReturn,response);


		return null;


	}

	/**
	 * 内存同步
	 */
	@RequestMapping(value = "synchro")
	public ModelAndView synchro(HttpSession session,HttpServletResponse response) throws Exception{
		
		Criteria criteria = new Criteria();
		criteria.setOrderByClause(" field desc ,sort asc ");
		criteria.put("enabled", "1");
		session.getServletContext().removeAttribute("fields");
		session.getServletContext().setAttribute("fields", baseFieldsService.selectAllByExample(criteria));
		responseJson(new ExtReturn(true, "同步成功！"),response);
		return null;
		
	}
}
