/**
* TODO
* @Project: lmframework
* @Title: IUserService.java
* @Package com.lmstudio.framework.bss.service
* @author jason.liu
* @Date 2015年10月27日 下午2:19:19
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.service;

import com.lmstudio.framework.bss.bo.User;

/**
* TODO
* @ClassName: IUserService
* @author json.liu
*/
public interface IUserService {

	User loadUserByUsername(String username);
}
