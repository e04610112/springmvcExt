package com.framework.base.exception;

/**
 * 异常处理器工厂
 * @author zhutx [Aug 18, 2012]
 *
 */
class ExceptionHandlerFactory {
	
	private ExceptionHandlerFactory(){}
	
	/**
	 * 获取异常处理器实例
	 * @author zhutx [Aug 18, 2012]
	 * @param type
	 * @return
	 */
	public static ExceptionHandler getInstance(String type){
		if("ajax".equals(type)){
			return new AjaxExceptionHandler();
		}else{
			return new NormalExceptionHandler();
		}
	}

}
