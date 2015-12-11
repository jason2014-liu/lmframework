/**
* TODO
* @Project: lmframework
* @Title: BaseJpaService.java
* @Package com.lmstudio.framework.bss.service
* @author jason.liu
* @Date 2015年10月21日 上午11:10:30
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmstudio.framework.bss.dao.IBaseJpaDao;

/**
* TODO
* @ClassName: BaseJpaService
* @author json.liu
*/
@Service(value="baseJpaService")
public class BaseJpaService {

	@Autowired
	protected IBaseJpaDao baseDao;
}
