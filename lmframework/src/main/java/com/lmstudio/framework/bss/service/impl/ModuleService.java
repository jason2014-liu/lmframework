/**
* TODO
* @Project: lmframework
* @Title: ModuleService.java
* @Package com.lmstudio.framework.bss.service.impl
* @author jason.liu
* @Date 2015年11月2日 上午11:21:41
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lmstudio.framework.bss.bo.Module;
import com.lmstudio.framework.bss.service.IModuleService;

/**
* TODO
* @ClassName: ModuleService
* @author json.liu
*/
@Service(value = "moduleService")
public class ModuleService extends BaseJpaService implements IModuleService {

	@Override
	@SuppressWarnings("rawtypes")
	public List<Module> findModulesByUser(String userId) {
		// TODO Auto-generated method stub
		//String jpql = "from Module where roles in (select roles from User where id = :userId)";
		String jpql = "from Module";
		Map<String,String> params = new HashMap<String,String>();
		//params.put("userId", userId);
		System.out.println("**************************");
		List list = this.baseDao.findListByQL(jpql, params);
		System.out.println("000000000000000000000000");
		if(list!=null){
			return (List<Module>)list;
		}
		return null;
	}

}
