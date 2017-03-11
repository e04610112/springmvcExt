package com.framework.base.entity;

import java.util.List;



public class Oper {

	
	private Long operId;
	private String operCode;
	private String username;
	private String password;
	private String realName;
	private String sex;
	private String phone;
	private String email;
	private String qq;
	private Long orgId;
	private String status;
	
	 private int firstResult;
		private int maxResult;
	private String roleNames;	
	public int getFirstResult() {
			return firstResult;
		}
		public void setFirstResult(int firstResult) {
			this.firstResult = firstResult;
		}
		public int getMaxResult() {
			return maxResult;
		}
		public void setMaxResult(int maxResult) {
			this.maxResult = maxResult;
		}
	
	public Long getOperId() {
		return operId;
	}
	public void setOperId(Long operId) {
		this.operId = operId;
	}
	public String getOperCode() {
		return operCode;
	}
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}


}
