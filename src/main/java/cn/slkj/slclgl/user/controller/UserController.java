package cn.slkj.slclgl.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.slkj.easyui.util.EPager;
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
	public EPager<User> getAllUsers(HttpServletRequest request,@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows) throws Exception {
//		int page = Integer.parseInt(request.getParameter("page"));
//		int rows = Integer.parseInt(request.getParameter("rows"));
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		List<User> list = userServiceImpl.getAllUsers(pageMap);
		int total = userServiceImpl.getAllUsersCount(pageMap);
		return new EPager<User>(total, list);
	}
}