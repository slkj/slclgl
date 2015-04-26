package cn.slkj.slclgl.devices.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.bean.Devices_record;
import cn.slkj.slclgl.devices.service.impl.DevicesServiceImpl;
import cn.slkj.slclgl.util.LocationUtil;

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
		pageMap.put("lytime1", request.getParameter("lytime1"));
		pageMap.put("fhtime", request.getParameter("fhtime"));
		pageMap.put("fhtime1", request.getParameter("fhtime1"));
		pageMap.put("state", request.getParameter("state"));
		pageMap.put("lyr", request.getParameter("lyr"));
		pageMap.put("firm", request.getParameter("firm"));
		// TODO 处理地区代码，如果后面有0的要like
		String area = request.getParameter("area");
		pageMap.put("area", area != null ? LocationUtil.toLocation(area) : area);
		pageMap.put("listnum", request.getParameter("listnum"));
		pageMap.put("phone", request.getParameter("phone"));
		pageMap.put("carNumber", request.getParameter("carNumber"));
		String sort = request.getParameter("sort");
		// if(StringUtils.isNotBlank(sort)){
		pageMap.put("sort", sort != null ? sort : "rktime");
		// }
		String order = request.getParameter("order");
		// if(StringUtils.isNotBlank(order)){
		pageMap.put("order", order != null ? order : "desc");
		// }
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = impl.getAllCount(pageMap);
		List<Devices> list = impl.getAll(pageMap);
		return new EPager<Devices>(total, list);
	}

	@RequestMapping("/getList")
	@ResponseBody
	public List<Devices> getList(HttpServletRequest request) throws Exception {
		int listnum = Integer.parseInt(request.getParameter("listnum"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listnum", listnum);
		return impl.getList(map);
	}

	@RequestMapping("/queryOne")
	@ResponseBody
	public Devices queryOne(String listnum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listnum", listnum);
		return impl.queryOne(map);
	}

	@RequestMapping(value = "/addDevices", method = { RequestMethod.POST })
	@ResponseBody
	public boolean addDevices(Devices devices) {
		int i = 0;
		if (devices.getAddType() == 1) {
			int begin = Integer.parseInt(devices.getListnum_begin());
			int end = Integer.parseInt(devices.getListnum_end());
			for (int j = begin; j <= end; j++) {
				devices.setListnum("");
				StringBuilder sb = new StringBuilder();
				sb.append(devices.getListNo());
				// 0 代表前面补充0
				// 4 代表长度为4
				// d 代表参数为正数型
				String str = String.format("%04d", j);
				sb.append(str);
				devices.setListnum(sb.toString());
				i = impl.insert(devices);
			}
		} else {
			i = impl.insert(devices);
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/editDevices", method = { RequestMethod.POST })
	@ResponseBody
	public boolean editDevices(Devices devices) {
		int i = impl.edit(devices);
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

	@RequestMapping(value = "/outRep")
	@ResponseBody
	public boolean outRep(@RequestParam(value = "ids[]") String[] ids, String area, String lyr,
			String lytime, String remark) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("area", area);
		map.put("lyr", lyr);
		map.put("lytime", lytime);
		map.put("remark", remark);
		int i = impl.outRepertory(map);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/deletes")
	@ResponseBody
	public boolean deletes(@RequestParam(value = "ids[]") String[] ids) {
		int i = impl.deletes(ids);
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
			impl.insert_record(devices);
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

	@RequestMapping("/recordList")
	@ResponseBody
	public EPager<Devices_record> getAllRecord(HttpServletRequest request) {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		pageMap.put("dev_id", request.getParameter("dev_id"));
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = impl.getAllRecordCount(pageMap);
		List<Devices_record> list = impl.getAllRecord(pageMap);
		return new EPager<Devices_record>(total, list);
	}
}
