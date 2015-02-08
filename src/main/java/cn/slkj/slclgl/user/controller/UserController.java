package cn.slkj.slclgl.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.slclgl.user.bean.User;
import cn.slkj.slclgl.user.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("login");
		User user_login = userServiceImpl.login(name, password);
		System.out.println(user_login);
		if (user_login == null) {
			System.out.println("Error login!");
			return "fail";
		} else {
			model.addAttribute("user", user_login);
			return "success";
		}
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<User> getAllUsers(Model model) {
		return userServiceImpl.getAllUsers();
	}
}