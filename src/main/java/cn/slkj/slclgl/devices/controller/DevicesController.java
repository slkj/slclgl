package cn.slkj.slclgl.devices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public EPager<Devices> getAll(HttpServletRequest request) throws Exception {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String rktime = request.getParameter("rktime");
		String rktime1 = request.getParameter("rktime1");
		String lytime = request.getParameter("lytime");
		String lytime1 = request.getParameter("lytime1");
		String fhtime = request.getParameter("fhtime");
		String fhtime1 = request.getParameter("fhtime1");
		String state = request.getParameter("state");
		String lyr = request.getParameter("lyr");
		String firm = request.getParameter("firm");
		pageMap.put("rktime", rktime);
		pageMap.put("rktime1", rktime1);
		pageMap.put("lytime", lytime);
		pageMap.put("lytime1", lytime1);
		pageMap.put("fhtime", fhtime);
		pageMap.put("fhtime1", fhtime1);
		pageMap.put("state", state);
		pageMap.put("lyr", lyr);
		pageMap.put("firm", firm);

		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = impl.getAllCount(pageMap);
		List<Devices> list = impl.getAll(pageMap);
		return new EPager<Devices>(total, list);
	}
	
	@RequestMapping(value = "/addDevices", method = { RequestMethod.POST })
	@ResponseBody
	public boolean addDevices(Devices devices) {
		int i = impl.insert(devices);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}
}
