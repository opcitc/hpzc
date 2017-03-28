package com.hpzc.model.shiro;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

//用户实体
public class ShiroToken extends UsernamePasswordToken implements Serializable {

	private static final long serialVersionUID = 1L;

	public ShiroToken(String username, String pswd) {
		super(username, pswd);
		this.pswd = pswd;

	}

	// 登录密码[字符串类型] 因为父类是char[] ] 因为父类中password是char[]类型
	// 所以子类如果子类其他类型的password会报错

	private String pswd;

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
