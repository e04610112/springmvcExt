package com.framework.base.exception;

public class ErrorBean {
	
	private String errorCode;
	private String level;
	private String message;
	private String cause;
	private String moveTo;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getMoveTo() {
		return moveTo;
	}
	public void setMoveTo(String moveTo) {
		this.moveTo = moveTo;
	}
	

}
