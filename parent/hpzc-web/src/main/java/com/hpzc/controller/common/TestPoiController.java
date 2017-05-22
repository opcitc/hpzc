package com.hpzc.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPoiController {

	@RequestMapping("poi")
	public String poi(Model mm) {
		mm.addAttribute("ss", "123456");
		System.out.println("kaptcha");
		return "tms/poi";
	}
}
