/**
* TODO
* @Project: lmframework
* @Title: ErrorCode.java
* @Package com.lmstudio.framework.bss.constants
* @author jason.liu
* @Date 2015年10月27日 下午4:22:57
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.constants;

/**
 * TODO
 * 
 * @ClassName: ErrorCode
 * @author json.liu
 */
public enum ErrorCode {

	//数据库操作
	DATA_SAVE_ERROR(100, "保存数据失败!"), 
	DATA_QUERY_ERROR(200, "查询数据失败!");
	
	private int code;
	private String message;

	private ErrorCode(int code) {
		this.code = code;
		this.message = "";
	}

	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	// 覆盖了父类Enum的toString()
	public String toString() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
