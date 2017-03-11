package com.framework.base.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.dao.ScheduleDao;
import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;
import com.framework.base.service.ScheduleService;
import com.framework.base.util.Parameters;
import com.google.gson.Gson;


@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	public static final Logger log = Logger.getLogger(ScheduleServiceImpl.class);
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	public void initFields(){
		//Parameters.fieldsMap.clear();
		Parameters.fieldsMaps.clear();
		List<BaseFields> list = scheduleDao.selectAllFiled(new Criteria());
		Map<String, HashMap<String, String>> all = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> part = null;
		for (int i = 0; i < list.size(); i++) {
			BaseFields baseFields = list.get(i);
			String key = baseFields.getField();
			if (all.containsKey(key)) {
				// 如果包含这个field，就加入它的值
				part = all.get(key);
				part.put(baseFields.getValueField(), baseFields.getDisplayField());
			} else {
				part = new HashMap<String, String>();
				part.put(baseFields.getValueField(), baseFields.getDisplayField());
				// 没有这个fiel，则新加入这个filed
				all.put(key, part);
			}
		}
		
		for (Entry<String, HashMap<String, String>> entry : all.entrySet()) {
			String key = entry.getKey();
			HashMap<String, String> value = entry.getValue();
			// 为了eval('(${applicationScope.fields.sex})')这个单引号使用,替换所有的'，为\'
			//Gson gson = new Gson();
			//String val = gson.toJson(value).replaceAll("\\'", "\\\\'");		
			//Parameters.fieldsMap.put(key, val);
			Parameters.fieldsMaps.put(key, value);
		}
	}
	

}
