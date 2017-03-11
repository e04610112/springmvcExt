package com.framework.base.util.dbpool;

public class DBConfigBean {
	 private String type     =""; //数据库类型
	 private String name     =""; //连接池名
	 private String driver   =""; //数据库驱动
	 private String url      =""; //数据库url
	 private String username =""; //用户名
	 private String password =""; //密码
	 private int maxcon  =30; //默认最大连接数
	 private int mincon  =20; //默认最小连接数
	 private int timeout  =5; //默认超时时间
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public int getMaxcon() {
		return maxcon;
	}
	public void setMaxcon(int maxcon) {
		this.maxcon = maxcon;
	}
	public int getMincon() {
		return mincon;
	}
	public void setMincon(int mincon) {
		this.mincon = mincon;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
