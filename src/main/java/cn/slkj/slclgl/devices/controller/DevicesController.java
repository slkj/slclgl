package cn.slkj.slclgl.devices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.service.impl.DevicesServiceImpl;

@Controller
@RequestMapping("/devices")
public class DevicesController {
	@Autowired
	private DevicesServiceImpl impl;

	@RequestMapping("/list")
	@ResponseBody
	public EPager<Devices> getAllUsers(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
//		int type = Integer.parseInt(request.getParameter("type"));
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = impl.getAllCount(pageMap);
		List<Devices> list = impl.getAll(pageMap);
		return new EPager<Devices>(total, list);
	}
}
