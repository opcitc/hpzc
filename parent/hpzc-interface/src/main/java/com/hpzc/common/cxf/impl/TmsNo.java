package com.hpzc.common.cxf.impl;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.hpzc.common.cxf.model.TmsImsWebService;

public class TmsNo {

	public static void main(String[] args) {

		JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
		svr.setServiceClass(TmsImsWebService.class);
		svr.setAddress("http://localhost:8080/fsscbs/ws/tmsImsNo");
		TmsImsWebService hw = (TmsImsWebService) svr.create();
		System.out.println(hw.mtTMSECCFITMSYXNO("8A87F97B507F22B6BCC2B4FDD9477E", "2000265026820004", "20170518"));
//		svr.getOutInterceptors().add(new AddHeaderInterceptor("zhangsan", "123456"));
	}
}
