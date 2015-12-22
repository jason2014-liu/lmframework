/**
* TODO
* @Project: lmframework
* @Title: ILocationService.java
* @Package com.lmstudio.framework.hr.service
* @author jason.liu
* @Date 2015年12月11日 上午10:46:03
* @Copyright
* @Version 
*/
package com.lmstudio.framework.hr.service;

import java.util.Map;

import com.lmstudio.framework.bss.dao.QueryResult;
import com.lmstudio.framework.hr.bo.Location;

/**
* TODO
* @ClassName: ILocationService
* @author jason.liu
*/
public interface ILocationService {

	/**
	* TODO
	* @Title: queryLocationsByPagination
	* @param params
	* @param pageNo
	* @param pageSize
	* @return
	 */
	QueryResult<Location> queryLocationsByPagination(Map<String,Object> params, int pageNo, int pageSize);
	
}
