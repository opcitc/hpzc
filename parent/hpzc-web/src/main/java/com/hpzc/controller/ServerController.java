package com.hpzc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hpzc")
public class ServerController {

	// 登录
	@RequestMapping("/login")
	public String login() {
		System.out.println("login");
		return "common/login";
	}

	// 首页
	@RequestMapping("/index")
	public String index() {
		return "common/index";
	}

	// 用户界面
	@RequestMapping("/hpzcUser")
	public String hpzcUser() {
		return "hpzcUser/hpzcUser";
	}

	// 采购单的路径
	@RequestMapping("/hpzcCgd")
	public String hpzcCgd() {
		return "hpzcCgd/hpzcCgd";
	}

	// 销售单的路径
	@RequestMapping("/hpzcXsd")
	public String hpzcXsd() {
		return "hpzcXsd/hpzcXsd";
	}

}
