/**
* TODO
* @Project: lmframework
* @Title: BssException.java
* @Package com.lmstudio.framework.bss.exception
* @author jason.liu
* @Date 2015年10月27日 下午4:20:20
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.exception;

import com.lmstudio.framework.bss.constants.ErrorCode;

/**
 * 业务逻辑的异常，主要在service层抛出。
 * 
 * <p>
 * 适用于因用户操作引起的，用户可以理解和避免的异常情况。
 */
public class BssException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;
	private String errorMessage;
	
	public BssException(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.errorMessage = errorCode.getMessage();
	}

	public BssException(ErrorCode errorCode, Throwable ex) {
		super(ex);
		this.code = errorCode.getCode();
		this.errorMessage = errorCode.getMessage();
	}

	public BssException(int code, String msg) {
		this.code = code;
		this.errorMessage = msg;
	}
	
	public BssException(ErrorCode errorCode, String msg) {
		this.code = errorCode.getCode();
		this.errorMessage = msg;
	}

	public BssException(ErrorCode errorCode, String msg, Throwable ex) {
		super(ex);
		this.code = errorCode.getCode();
		this.errorMessage = msg;
	}

	public int getCode() {
		return code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	@Override
	public String getMessage() {
		return errorMessage;
	}
}
