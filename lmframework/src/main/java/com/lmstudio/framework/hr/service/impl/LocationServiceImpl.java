package com.lmstudio.framework.hr.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.lmstudio.framework.bss.dao.QueryResult;
import com.lmstudio.framework.bss.service.impl.BaseJpaService;
import com.lmstudio.framework.hr.bo.Location;
import com.lmstudio.framework.hr.service.ILocationService;

@Service(value="locationService")
public class LocationServiceImpl extends BaseJpaService implements ILocationService {

	@Override
	public QueryResult<Location> queryLocationsByPagination(Map<String, Object> params, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String jpql = "from Location";
		return this.baseDao.findByJPQLWithPage(jpql, params, pageNo, pageSize);
	}

}
