package com.hpzc.common.cxf.impl;

import java.util.List;

import javax.xml.namespace.QName;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.hpzc.model.exception.BizException; //自定义异常类

public class AddHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	private String userName;
	private String password;

	public AddHeaderInterceptor(String userName, String password) {
		super(Phase.PREPARE_SEND);
		this.userName = userName;
		this.password = password;
	}

	@Override
	public void handleMessage(SoapMessage msg) throws BizException {

		List<Header> headers = msg.getHeaders();

		// 创建Document对象
		Document document = DOMUtils.createDocument();
		Element element = document.createElement("authHeader");

		// 配置服务器端Head信息的用户密码
		Element userNameElement = document.createElement("userName");
		userNameElement.setTextContent(userName);
		System.out.println(userNameElement.getElementsByTagName("userName"));
		Element passwordElement = document.createElement("password");
		passwordElement.setTextContent(password);

		element.appendChild(userNameElement);
		element.appendChild(passwordElement);
		headers.add(new Header(new QName(""), element));
		/**
		 * 生成的XML文档 <authHeader> <userName>zhangsan</userName>
		 * <password>123456</password> </authHeader>
		 */
	}
}
