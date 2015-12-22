/**
* TODO
* @Project: lmframework
* @Title: QueryResult.java
* @Package com.lmstudio.framework.bss.dao
* @author jason.liu
* @Date 2015年12月16日 下午2:13:48
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.dao;

import java.util.ArrayList;
import java.util.List;

/**
* TODO
* @ClassName: QueryResult
* @author jason.liu
*/
public class QueryResult<T> {

	/** 当前页结果集 */
	private List<T> resultList;

	/** 记录总数 */
	private Long totalRecord;

	/** 每页记录数 */
	private Integer pageSize;

	/** 当前页号 */
	private Integer currPageNo;

	/** 总页数 */
	private Long pageCount;
	
	public QueryResult(List<T> resultList, long totalRecord, int currPageNo, int pageSize) {
		this.resultList = resultList == null ? new ArrayList<T>() : resultList;
		this.totalRecord = totalRecord;
		this.currPageNo = currPageNo;
		this.pageSize = pageSize;
		this.pageCount = (totalRecord + pageSize - 1) / pageSize;
	}

	@Override
	public String toString() {
		return String.format("QueryResult [resultList=%s, totalRecord=%s, pageSize=%s, currPageNo=%s, pageCount=%s]", resultList, totalRecord,
				pageSize, currPageNo, pageCount);
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
