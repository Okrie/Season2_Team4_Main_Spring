package com.springlec.base.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springlec.base.service.user.NUserService;

@Controller
public class NUserController {

	@Autowired
	NUserService service;
}
