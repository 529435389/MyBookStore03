package edu.sdp.com.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/manager")
@Controller
public class ManagerHandler {
	@RequestMapping("/managerLogin")
	public String login() {

		return "manager/manager";
	}
}
