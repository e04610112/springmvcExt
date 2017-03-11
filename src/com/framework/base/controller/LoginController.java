package com.framework.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.framework.base.entity.BaseUsers;
import com.framework.base.entity.ExtReturn;
import com.framework.base.entity.Tree;
import com.framework.base.service.LoginService;
import com.framework.base.util.MD5Util;
import com.framework.base.util.Parameters;
import com.framework.base.util.WebConstants;
import com.framework.base.util.mq.SpringMQSend;
import com.google.gson.Gson;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private SpringMQSend springMQSend;
	
public SpringMQSend getSpringMQSend() {
		return springMQSend;
	}
	public void setSpringMQSend(SpringMQSend springMQSend) {
		this.springMQSend = springMQSend;
	}
	//	@RequestMapping(value="toLogin")
//	public ModelAndView toLogin(){
//		//loginService.Test();
//		return new ModelAndView("common/login");
//	}
//	
//	@RequestMapping(value="login")
//    public ModelAndView login(Oper oper,String checkCode,HttpServletRequest request,HttpServletResponse response){
//		Oper opernew=loginService.getOperForLogin(oper);
//    		return new ModelAndView("common/login");
//    	
//    }
//	
//	@RequestMapping(value="updateUser")
//    public ModelAndView updateUser(Oper oper,String checkCode,HttpServletRequest request,HttpServletResponse response){
//			loginService.updateUser(oper);
//    		return new ModelAndView("common/login");
//    	
//    }
//
//	@RequestMapping(value="logout")
//	public ModelAndView logout(HttpServletRequest request){
//		
//			return new ModelAndView("redirect:toLogin.do");
//		
//	}
//	
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(String account, String password, HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		springMQSend.sendMessageToMQ();
		ExtReturn extReturn=null;
		if (StringUtils.isBlank(account)) {
			extReturn= new ExtReturn(false, "帐号不能为空！");
		}
		if (StringUtils.isBlank(password)) {
			extReturn= new ExtReturn(false, "密码不能为空！");
		}
//			Criteria criteria = new Criteria();
//			criteria.put("account", account);
//			criteria.put("passwordIn", password);
//			criteria.put("loginip", this.getIpAddr(request));
		//String result = this.baseUsersService.selectByBaseUser(criteria);
		BaseUsers baseUser=loginService.getBaseUserForLogin(account,MD5Util.MD5(password));
		if (baseUser!=null) {
			session.setAttribute(WebConstants.CURRENT_USER, baseUser);
			extReturn= new ExtReturn(true, "success");
		} else {
			extReturn= new ExtReturn(false, "用户名或者密码错误!");
		} 
		responseJson(extReturn,response);
		return null;
	}
	/**
	 * 用户菜单treeMenu的数据
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value ="treeMenu")
	public ModelAndView treeMenu(HttpSession session, HttpServletResponse response) {
		
			BaseUsers user = (BaseUsers) session.getAttribute(WebConstants.CURRENT_USER);
			// 得到的是根菜单
			Tree tree = loginService.selectModulesByUser(user);
			// 返回根菜单下面的子菜单
			responseJson(tree.getChildren(),response);		
		return null;
	}
	/**
	 * 主页
	 */
//	@RequestMapping(value ="/")
//	public String home(HttpServletRequest request,HttpServletResponse response) {
//		// 转到登录页面
//		return "login";
//		//return new ModelAndView("login");
//	}

	/**
	 * 主页面
	 */
	@RequestMapping(value="main")
	public String main(HttpServletRequest request,HttpServletResponse response) {
		
		Gson gson = new Gson();
		request.getSession().setAttribute("fieldsMaps", gson.toJson(Parameters.fieldsMaps));
		return "main";
		//return new ModelAndView("main");
	}

	/**
	 * 头部
	 */
	@RequestMapping(value="header")
	public String header(HttpServletRequest request,HttpServletResponse response) {
		return "header";
		//return new ModelAndView("header");
	}

	/**
	 * 欢迎界面
	 */
	@RequestMapping(value="welcome")
	public String welcome(HttpServletRequest request,HttpServletResponse response) {
		return "welcome";
		//return new ModelAndView("welcome");
	}
	/**
	 * 取得客户端真实ip
	 * 
	 * @param request
	 * @return 客户端真实ip
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();	
		}
		return ip;
	}
	
	
}