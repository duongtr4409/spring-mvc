package com.duongnv30.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duongnv30.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Override
	public List<String> loadMenu() {
		List<String> menus = new ArrayList<>();
		menus.add("Nguyen Van Duong");
		menus.add("       <3       ");
		menus.add("Nguyen Thanh Tra");
		return menus;
	}

}
