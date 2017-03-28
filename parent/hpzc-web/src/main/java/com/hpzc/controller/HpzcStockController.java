package com.hpzc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hpzcStock")
public class HpzcStockController {

	@RequestMapping("/hpzcStock")
	public String Hpzc() {
		System.out.println(12);
		return "common/index";
	}

}
