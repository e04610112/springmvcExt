package com.framework.base.util.hessian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Citation implements Serializable{
	private String name;
	private List<Integer> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
}
