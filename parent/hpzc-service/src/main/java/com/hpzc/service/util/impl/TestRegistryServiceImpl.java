package com.hpzc.service.util.impl;

import org.springframework.stereotype.Service;

import com.hpzc.service.util.TestRegistryService;

@Service("testRegistryService")
public class TestRegistryServiceImpl implements TestRegistryService {

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return name;
	}

}
