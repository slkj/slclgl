package cn.slkj.slclgl.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.easyui.util.JsonResult;
import cn.slkj.slclgl.user.bean.User;
import cn.slkj.slclgl.user.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HashMap<String, Object> hashMap= new HashMap<String, Object>();
		hashMap.put("username",username.trim());
		hashMap.put("password",password.trim());
		User user_login = userServiceImpl.login(hashMap);
		if (user_login == null) {
			return new JsonResult(false, "用户名称或密码错误！");
		} else {
			model.addAttribute("user", user_login);
			return new JsonResult(true, "登录成功。");
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
	
	/** 保存用户信息 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonResult save(User user){
		try {
			HashMap<String, Object> hashMap= new HashMap<String, Object>();
			hashMap.put("username",user.getUsername().trim());
			User u = userServiceImpl.queryOne(hashMap);
			int i =-1;
			if (u != null) {
				return new JsonResult(false, "用户已经存在，请重新填写。");
			} else {
				i  = userServiceImpl.save(user);
			}
			if (i != -1) {
				return new JsonResult(true, "操作成功。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(false, "操作失败！");
	}
}