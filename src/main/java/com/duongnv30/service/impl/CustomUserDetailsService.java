package com.duongnv30.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.duongnv30.constant.SystemConstant;
import com.duongnv30.dto.MyUser;
import com.duongnv30.entity.RoleEntity;
import com.duongnv30.entity.UserEntity;
import com.duongnv30.repository.UserRepositoty;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepositoty userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_USER);

		if(userEntity == null) {
			throw new UsernameNotFoundException("Account not found!");
		}
		
		List<RoleEntity> listRoles = userEntity.getListRole();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role : listRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassWord(), true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
