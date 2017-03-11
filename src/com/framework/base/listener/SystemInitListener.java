package com.framework.base.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.framework.base.entity.Criteria;
import com.framework.base.quartz.MySchedule;
import com.framework.base.service.BaseFieldsService;

/**
 * 系统初始化监听器
 */
public class SystemInitListener implements ServletContextListener {
	private WebApplicationContext springContext;
	public static final Logger log = Logger.getLogger(MySchedule.class);
	public void contextInitialized(ServletContextEvent event) {
		log.info("--------------SystemInitListener-----------------");
		ServletContext servletContext = event.getServletContext();
		springContext=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()); //获取spring上下文！  
		BaseFieldsService baseFieldsService=null;
		if(springContext!=null){
			baseFieldsService = (BaseFieldsService)springContext.getBean("baseFieldsServiceImpl");
		}else{
			System.out.println("加载错误");
		}
		 
		Criteria criteria = new Criteria();
		criteria.setOrderByClause(" field desc ,sort asc ");
		criteria.put("enabled", "1");//启用
		servletContext.setAttribute("fields", baseFieldsService.selectAllByExample(criteria));
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}



}
