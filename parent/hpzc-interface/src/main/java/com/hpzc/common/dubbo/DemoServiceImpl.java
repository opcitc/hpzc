package com.hpzc.common.dubbo;

public class DemoServiceImpl implements DubboService {

	@Override
	public String SayHello(String name) {
		System.out.println("Hello World");
		return "Hello:dubbo" + name;
	}

}
