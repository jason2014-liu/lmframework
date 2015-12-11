/**
* TODO
* @Project: lmframework
* @Title: CustomUserDeatailsService.java
* @Package com.lmstudio.framework.bss.service.impl
* @author jason.liu
* @Date 2015年10月27日 下午3:39:29
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lmstudio.framework.bss.service.IUserService;

/**
 * 该类的主要作用是给AuthenticationManager提供provider，进行用户认证并为Spring
 * Security提供一个经过用户认证后的UserDetails。 该UserDetails包括用户名、密码、是否可用、是否过期等信息。
 */
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

//		User user = userService.loadUserByUsername(username);
//
//		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
//				user.getPassword(), getGrantedAuthorities(user));
//
//		return userDetails;
		
		if(!"jimi".equals(username) && !"bobo".equals(username)){
			throw new UsernameNotFoundException("用户"+username+"不存在");
		}
		
		String password = null;

		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		// 虚拟几个权限
		GrantedAuthorityImpl auth1 = new GrantedAuthorityImpl("ROLE_USER");
		GrantedAuthorityImpl auth2 = new GrantedAuthorityImpl("ROLE_ADMIN");

		if ("jimi".equals(username)) {
			auths.add(auth1);
			auths.add(auth2);
			password = "jimispassword";
		}

		if ("bobo".equals(username)) {
			auths.add(auth1);
			password = "bobospassword";
		}
		
		User user = new User(username, password, true, true, true, true,
				auths);
		return user;
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(String username) {
		return null;
	}

}
