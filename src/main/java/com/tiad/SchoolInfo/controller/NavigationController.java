package com.tiad.SchoolInfo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiad.SchoolInfo.common.loggin.Logging;

@Controller
public class NavigationController {
	@Logging(NavigationController.class)
	Logger logger;

	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
}
