/**
* TODO
* @Project: lmframework
* @Title: UserService.java
* @Package com.lmstudio.framework.bss.service.impl
* @author jason.liu
* @Date 2015年10月27日 下午2:19:47
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lmstudio.framework.bss.bo.User;
import com.lmstudio.framework.bss.service.IUserService;

/**
 * TODO
 * 
 * @ClassName: UserService
 * @author json.liu
 */
@Service(value = "userService")
public class UserService extends BaseJpaService implements IUserService {

	@Override
	public User loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		String jpql = "from User where username = :username";
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		
		return this.baseDao.findSingleByQL(User.class, jpql, params);
	}

}
