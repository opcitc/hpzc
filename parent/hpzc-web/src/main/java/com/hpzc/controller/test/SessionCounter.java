package com.hpzc.controller.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public  class SessionCounter implements HttpSessionListener {

	private static int activeSession = 0;

	@Override
	public void sessionCreated(HttpSessionEvent ss) {
		activeSession++;

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent ss) {
		if (activeSession > 0) {
			activeSession--;
		}
	}

	// 获取在线人数
	public static int getSession() {
		System.out.println("第:"+activeSession);
		return activeSession;
	}

}
