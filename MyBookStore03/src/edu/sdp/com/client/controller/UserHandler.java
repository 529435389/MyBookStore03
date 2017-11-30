package edu.sdp.com.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.sdp.com.client.service.UserService;
import edu.sdp.com.entities.User;

@SessionAttributes(value = "user")
@RequestMapping("/user")
@Controller
public class UserHandler {
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(User user, Map<String, Object> map) {
		User sqlUser = userService.login(user);
		if (sqlUser == null) {
			// 不往map中存，返回到登陆界面
			map.put("msg", "用户名或密码错误");
			// 使用转发
			return "user/login";
		} else {
			map.put("user", sqlUser);
		}
		return "user/login_success";
	}

}
