package com.springlec.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NController {

	
	@RequestMapping("/")
	public String mainView() throws Exception {
		return "index";
	}
}
