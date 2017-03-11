package com.framework.base.quartz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.framework.base.service.ScheduleService;

public class MySchedule {
	
	public static final Logger log = Logger.getLogger(MySchedule.class);
	
	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 服务器启动5秒后执行
	 * @author 
	 */
	public void runBySeverStart(){
		
		log.info("--------------Start：runByServerStart()-----------------");
		scheduleService.initFields();
//		scheduleService.initConstant();
//		scheduleService.initOrg();
//		scheduleService.initAreaColumnData();
//		scheduleService.initOrgColumnData();
//		scheduleService.initOperColumnData();
//		scheduleService.initRoleColumnData();
//		scheduleService.initFlowTemplateColumnData();
//		scheduleService.initFlowTemplateNodeColumnData();
//		scheduleService.initWorkFlowMemuLink();
//		scheduleService.initWorkFlowNodelink();
//		scheduleService.initPosVersion();
//		scheduleService.initWorkFlowNodeRoleName();
//		scheduleService.iniLogUrl();
		log.info("--------------End  ：runByServerStart()-------------------");
	}
	
	public void runByHour(){
		log.info("--------------Start：runMyHour()-----------------");
		log.info("--------------End：runMyHour()-------------------");
	}
	
	/**
	 * 每天凌晨00:30执行
	 * @author 
	 */
	public void runByMidnight(){
		
		log.info("--------------Start：runByMidnight()-----------------");
		log.info("--------------End：runByMidnight()-------------------");
		
	}
	


}
