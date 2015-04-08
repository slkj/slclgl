package cn.slkj.slclgl.devices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
		pageMap.put("rktime", request.getParameter("rktime"));
		pageMap.put("rktime1", request.getParameter("rktime1"));
		pageMap.put("lytime", request.getParameter("lytime"));
		pageMap.put("lytime1",  request.getParameter("lytime1"));
		pageMap.put("fhtime", request.getParameter("fhtime"));
		pageMap.put("fhtime1", request.getParameter("fhtime1"));
		pageMap.put("state", request.getParameter("state"));
		pageMap.put("lyr", request.getParameter("lyr"));
		pageMap.put("firm", request.getParameter("firm"));
		pageMap.put("area", request.getParameter("area"));
		pageMap.put("listnum", request.getParameter("listnum"));
		pageMap.put("phone", request.getParameter("phone"));
		pageMap.put("carNumber", request.getParameter("carNumber"));
		String sort =request.getParameter("sort");
//		if(StringUtils.isNotBlank(sort)){
			pageMap.put("sort", sort != null ? sort : "rktime");
//		}
		String order =request.getParameter("order");
//		if(StringUtils.isNotBlank(order)){
			pageMap.put("order", order != null  ? order : "desc");
//		}
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
	@RequestMapping(value = "/outRepertory", method = { RequestMethod.POST })
	@ResponseBody
	public boolean outRepertory(Devices devices) {
		int i = impl.outRepertory(devices);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
	@RequestMapping(value = "/goBack", method = { RequestMethod.POST })
	@ResponseBody
	public boolean goBack(Devices devices) {
		int i = impl.goBack(devices);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
	@RequestMapping(value = "/testing", method = { RequestMethod.POST })
	@ResponseBody
	public boolean testing(Devices devices) {
		int i = impl.testing(devices);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
	@RequestMapping(value = "/netIn", method = { RequestMethod.POST })
	@ResponseBody
	public boolean netIn(Devices devices) {
		int i = impl.netIn(devices);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
}
