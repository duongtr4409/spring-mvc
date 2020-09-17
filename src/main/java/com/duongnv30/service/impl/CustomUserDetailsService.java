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
import com.duongnv30.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_USER);
		if(userEntity == null) {
			throw new UsernameNotFoundException("UserName not found!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<RoleEntity> listRole = userEntity.getListRole();
		for(RoleEntity role : listRole) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities, userEntity.getFullName());
		return myUser;
	}

}
