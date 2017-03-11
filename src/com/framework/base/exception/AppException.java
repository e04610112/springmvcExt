package com.framework.base.exception;


public class AppException extends RuntimeException {
	
	private static final long serialVersionUID = 8976154108100127087L;
	
	private String errorCode;
	
	private String myCause;
	
	public AppException(String errorCode){
		this.errorCode = errorCode;
	}
	
	public AppException(String errorCode, String cause){
		this.errorCode = errorCode;
		this.myCause = cause;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMyCause() {
		return myCause;
	}

	public void setMyCause(String myCause) {
		this.myCause = myCause;
	}

}
