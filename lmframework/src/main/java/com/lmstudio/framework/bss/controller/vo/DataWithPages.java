/**
* TODO datagrid with pagination  for jquery easyui
* @Project: lmframework
* @Title: DataWithPages.java
* @Package com.lmstudio.framework.bss.controller.vo
* @author jason.liu
* @Date 2015年12月16日 下午2:05:58
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.controller.vo;

import java.util.List;

/**
 * TODO
 * 
 * @ClassName: DataWithPages
 * @author jason.liu
 */
@SuppressWarnings(value = "rawtypes")
public class DataWithPages {

	private long total;
	private List rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
