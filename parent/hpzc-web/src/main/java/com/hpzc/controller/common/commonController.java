package com.hpzc.controller.common;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Controller
public class commonController {

	@Autowired
	private Producer captchaProducer = null;

	@RequestMapping("kaptcha")
	public String kaptcha() {
		System.out.println("kaptcha");
		return "tms/kaptcha";
	}

	@RequestMapping(value = "/getCaptchaImage.htm")
	public ModelAndView getCaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("******************验证码是: " + code + "******************");

		response.setDateHeader("Expires", 0);

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// return a jpeg
		response.setContentType("image/jpeg");

		// create the text for the image
		String capText = captchaProducer.createText();

		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();

		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping("checkCode")
	public String kaptchaJson(HttpServletRequest request, HttpServletResponse response) {

		// 获取用户输入的验证码
		String submitCode = WebUtils.getCleanParam(request, "j_code");

		// 从session中获取系统生成的验证码
		String kaptchaExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		System.out.println("用户输入的验证码是：" + submitCode + ",系统生成的验证码：" + kaptchaExpected);
		// 进行比较
		if (StringUtils.isEmpty(submitCode) || StringUtils.equalsIgnoreCase(submitCode, kaptchaExpected)) {

			request.setAttribute("checkCode", "验证码正确！");
		} else {
			request.setAttribute("checkCode", "验证码错误！");
		}
		return "tms/kaptcha";
	}

}
