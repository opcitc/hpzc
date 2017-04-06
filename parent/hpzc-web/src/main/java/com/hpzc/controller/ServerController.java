package com.hpzc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpzc.model.shiro.ShiroToken;

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
	public String index(String username, String password) {
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
	
	@ResponseBody
	@RequestMapping("/indexinfo")
	public String indexinfo(HttpServletRequest request, HttpServletResponse response, HttpSession hession) {
		// 验证登录增加权限控制!
		String username = request.getParameter("manager");
		String password = request.getParameter("password");
		// MD5加密
		// String pass = Md5.string2MD5(password);
		// shiro验证
		ShiroToken token = new ShiroToken(username, password);
		SecurityUtils.getSubject().login(token);
		return "1";
	}

}
