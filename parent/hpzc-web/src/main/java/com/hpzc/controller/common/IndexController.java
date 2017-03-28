package com.hpzc.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hpzcWest")
public class IndexController {
	@RequestMapping("/tttindex")
	public String index() {
		System.out.println(12);
		return "easyui/tabs";
	}

}
