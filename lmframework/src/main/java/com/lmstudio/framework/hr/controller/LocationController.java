/**
* TODO
* @Project: lmframework
* @Title: LocationController.java
* @Package com.lmstudio.framework.hr.controller
* @author jason.liu
* @Date 2015年12月11日 上午11:17:00
* @Copyright
* @Version 
*/
package com.lmstudio.framework.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmstudio.framework.bss.controller.vo.DataWithPages;
import com.lmstudio.framework.bss.dao.QueryResult;
import com.lmstudio.framework.hr.bo.Location;
import com.lmstudio.framework.hr.service.ILocationService;

/**
* TODO
* @ClassName: LocationController
* @author jason.liu
*/
@Controller
@RequestMapping(value="/hr")
public class LocationController {
	
	@Autowired
	private ILocationService locationService;
	

	@RequestMapping(value="/toLocationList", method=RequestMethod.GET)
	public String toLocationList(){
		return "hr/locationList";
	}
	
	/**
	* TODO
	* @Title: queryLocations
	* @return
	 */
	@RequestMapping(value="/queryLocations", method=RequestMethod.POST)
	@ResponseBody
	public DataWithPages queryLocations(@RequestParam("page")int page,@RequestParam("rows")int rows){
		
		QueryResult<Location> result = locationService.queryLocationsByPagination(null, page, rows);
		
		DataWithPages data = new DataWithPages();
		data.setRows(result.getResultList());
		data.setTotal(result.getTotalRecord());
		return data;
	}
}
