/**
* TODO
* @Project: lmframework
* @Title: IModuleService.java
* @Package com.lmstudio.framework.bss.service
* @author jason.liu
* @Date 2015年11月2日 上午11:20:27
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.service;

import java.util.List;

import com.lmstudio.framework.bss.bo.Module;

/**
* TODO
* @ClassName: IModuleService
* @author json.liu
*/
public interface IModuleService {

	List<Module> findModulesByUser(String userId);
}
