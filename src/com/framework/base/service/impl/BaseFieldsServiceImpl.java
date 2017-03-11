package com.framework.base.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.dao.BaseFieldsDao;
import com.framework.base.entity.BaseFields;
import com.framework.base.entity.Criteria;
import com.framework.base.service.BaseFieldsService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;



@Service
public class BaseFieldsServiceImpl implements BaseFieldsService {
	@Autowired
	private BaseFieldsDao baseFieldsDao;

	// static final Logger logger = LoggerFactory.getLogger(BaseFieldsServiceImpl.class);

	public int countByExample(Criteria example) {
		int count = this.baseFieldsDao.countByExample(example);
		//logger.debug("count: {}", count);
		return count;
	}
//
//	public BaseFields selectByPrimaryKey(String fieldId) {
//		return this.baseFieldsMapper.selectByPrimaryKey(fieldId);
//	}
//
	public List<BaseFields> selectByExample(Criteria example) {
		return this.baseFieldsDao.selectByExample(example);
	}

	@Override
	public HashMap<String, String> selectAllByExample(Criteria example) {
		List<BaseFields> list = this.baseFieldsDao.selectAllByExample(example);
		HashMap<String, LinkedHashMap<String, String>> all = new HashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> part = null;
		for (int i = 0; i < list.size(); i++) {
			BaseFields baseFields = list.get(i);
			String key = baseFields.getField();
			if (all.containsKey(key)) {
				// 如果包含这个field，就加入它的值
				part = all.get(key);
				part.put(baseFields.getValueField(), baseFields.getDisplayField());
			} else {
				part = new LinkedHashMap<String, String>();
				part.put(baseFields.getValueField(), baseFields.getDisplayField());
				// 没有这个fiel，则新加入这个filed
				all.put(key, part);
			}
		}
		part = new LinkedHashMap<String, String>();
		//logger.info("开始读取系统默认配置");
		for (Entry<String, LinkedHashMap<String, String>> entry : all.entrySet()) {
			String key = entry.getKey();
			HashMap<String, String> value = entry.getValue();
			// 为了eval('(${applicationScope.fields.sex})')这个单引号使用,替换所有的'，为\'
			Gson gson = new Gson();
			String val = gson.toJson(value).replaceAll("\\'", "\\\\'");
			
			part.put(key, val);
		}
		//logger.info("结束读取系统默认配置");
		return part;
	}

	@Override
	public String saveFields(Criteria example) {
		BaseFields baseFields = (BaseFields) example.get("fields");

		int result = 0;
		if (baseFields.getFieldId() == null||"".endsWith(baseFields.getFieldId())) {
			result = this.baseFieldsDao.insertBaseFields(baseFields);
		} else {
			result = this.baseFieldsDao.updateBaseFields(baseFields);
		}
		return result > 0 ? "01" : "00";
	}

	@Override
	
	public String deleteFields(Criteria example) {
		String fieldId = example.getAsString("fieldId");
		int result = 0;
		// 删除自己
		result = this.baseFieldsDao.deleteBaseFieldsById(fieldId);
		return result > 0 ? "01" : "00";
	}

}